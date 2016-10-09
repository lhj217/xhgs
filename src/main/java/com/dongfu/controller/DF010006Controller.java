package com.dongfu.controller;

import com.dongfu.util.Utils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DF010006Controller
 * @Description: 查询书籍章节列表
 * @author Fordring
 * @date 2016/08/29
 * @version V1.0
 */
@Controller
public class DF010006Controller {

	private static final Logger logger = LoggerFactory.getLogger(DF010006Controller.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/chapter/{bookId}/{pageNum}.html", method = { RequestMethod.GET })
	public String Catalog(@PathVariable("bookId") String bookId, @PathVariable("pageNum") String pageNum,
			Map<String, Object> result) {
		if (pageNum == null || "".equals(pageNum.trim())) {
			pageNum = "0";
		}
		logger.info("bookId:" + bookId + ";pageNum:" + pageNum);
		Map<String, Object> bookInfo = sqlSession.selectOne("t_book_info.findByBookId", bookId);
		Map<String, Object> param = new HashMap<>();
		param.put("bookId", bookId);
		param.put("start", (Integer.valueOf(pageNum) * 20));
		List<Map<String, Object>> chapters = sqlSession.selectList("t_book_chapter.findByBookIdLimit", param);
		int count = sqlSession.selectOne("t_book_chapter.countByBookId", param);
		List<Map<String, Object>> list = Utils.getGroup(count);
		int previousPageNum = 0;
		int nextPageNum;
		if ("0".equals(pageNum)) {
			nextPageNum = 1;
		} else {
			previousPageNum = Integer.valueOf(pageNum) - 1;
			nextPageNum = Integer.valueOf(pageNum) + 1;
		}

		// 系统参数
		List<Map<String, Object>> sysParams = sqlSession.selectList("t_sys_param.findBy");
		// seo信息
		String title = "";
		String keywords = "";
		String description = "";
		for (int i = 0; i < sysParams.size(); i++) {
			Map<String, Object> sysParam = sysParams.get(i);
			if ("catalog_title".equals(sysParam.get("param_key") + "")) {
				title = (sysParam.get("param_value") + "").replaceAll("bookName", bookInfo.get("book_name") + "");
			}
			if ("catalog_keywords".equals(sysParam.get("param_key") + "")) {
				keywords = (sysParam.get("param_value") + "").replaceAll("bookName", bookInfo.get("book_name") + "");
			}
			if ("catalog_description".equals(sysParam.get("param_key") + "")) {
				description = sysParam.get("param_value") + "";
			}
		}

		Map<String, Object> seo = new HashMap<>();
		seo.put("title", title);
		seo.put("keywords", keywords);
		seo.put("description", description);
		result.put("seo", seo);
		result.put("chapters", chapters);
		result.put("bookInfo", bookInfo);
		result.put("groups", list);
		result.put("previousPageNum", previousPageNum);
		result.put("currentPageNum", pageNum);
		result.put("nextPageNum", nextPageNum);
		return "chapter";
	}
}
