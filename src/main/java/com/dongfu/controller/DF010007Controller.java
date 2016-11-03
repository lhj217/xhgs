package com.dongfu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongfu.util.Constant;
import com.dongfu.util.ReadFile;

/**
 * @ClassName: DF010007Controller
 * @Description: 查询书籍指定章节内容
 * @author Fordring
 * @date 2016/08/29
 * @version V1.0
 */
@Controller
public class DF010007Controller {

	private static final Logger logger = LoggerFactory.getLogger(DF010007Controller.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/{bookId}/{chapterId}.html", method = { RequestMethod.GET })
	public String Content(@PathVariable("bookId") String bookId, @PathVariable("chapterId") String chapterId,
			Map<String, Object> result, HttpServletRequest request, HttpServletResponse response) {
		logger.info("bookId:" + bookId + ";chapterId:" + chapterId);
		sqlSession.update("t_book_info.updateByBookId", bookId);
		Map<String, Object> bookInfo = sqlSession.selectOne("t_book_info.findBooKInfoAndChapterByBookId", bookId);
		Map<String, Object> params = new HashMap<>();
		params.put("chapterId", chapterId);
		params.put("bookId", bookId);
		Map<String, Object> chapterInfo = sqlSession.selectOne("t_book_chapter.findByChapterId", params);
		Map<String, Object> maxAndMinChapterId = sqlSession.selectOne("t_book_chapter.findMaxAndMinChapterId", params);
		Map<String, String> content = ReadFile.readTxtFileByLine(Constant.BOOK_BASE_DIR + bookId + "/" + chapterId + ".txt");
		// 系统参数
		List<Map<String, Object>> sysParams = Constant.seoParams;
		// seo信息
		String title = "";
		String keywords = "";
		String description = "";
		String chapterContent = "小编正在处理中,请稍后...";
		if (null != content) {
			description = content.get("description").trim().substring(0, 140);
			chapterContent = content.get("newContent");
		}

		for (int i = 0; i < sysParams.size(); i++) {
			Map<String, Object> sysParam = sysParams.get(i);
			if ("content_title".equals(sysParam.get("param_key") + "")) {
				title = (sysParam.get("param_value") + "").replace("bookName", bookInfo.get("book_name") + "")
						.replace("chapterName", chapterInfo.get("chapter_title") + "");
			}
			if ("content_keywords".equals(sysParam.get("param_key") + "")) {
				keywords = (sysParam.get("param_value") + "").replace("bookName", bookInfo.get("book_name") + "")
						.replace("chapterName", chapterInfo.get("chapter_title") + "");
			}
			// if ("content_description".equals(sysParam.get("param_key") + ""))
			// {
			// description = (sysParam.get("param_value") +
			// "").replace("bookName", bookInfo.get("book_name") + "")
			// .replace("bookAuth", bookInfo.get("book_auth") + "");
			// }
		}

		Map<String, Object> seo = new HashMap<>();
		seo.put("title", title);
		seo.put("keywords", keywords);
		seo.put("description", description);

		// Cookie[] cookies = request.getCookies();
		// for (Cookie cookie : cookies) {
		// System.out.println("cookie Name:" + cookie.getName() + " cookie
		// Value:" + cookie.getValue());
		// if("".equals(cookie.getName())){
		// cookie.getValue();
		// }else if("".equals(cookie.getName())){
		//
		// }
		// }

		// Cookie colorCookie = new Cookie("bgcolor", "bgcolor1");
		// Cookie sizeCookie = new Cookie("fontsize","fontsize1");
		// colorCookie.setMaxAge(7200);
		// colorCookie.setPath("/xhgs");
		// sizeCookie.setMaxAge(7200);
		// response.addCookie(colorCookie);
		// request.addCookie(sizeCookie);

		result.put("seo", seo);
		result.put("minChapterId", maxAndMinChapterId.get("mi"));
		result.put("maxChapterId", maxAndMinChapterId.get("ma"));
		result.put("bookName", bookInfo.get("book_name"));
		result.put("chapterInfo", chapterInfo);
		result.put("chapterContent", chapterContent);
		return "chapterContent";
	}
}
