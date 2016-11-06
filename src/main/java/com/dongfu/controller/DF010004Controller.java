package com.dongfu.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DF010004Controller
 * @Description: 根据书名或者作者搜索书籍
 * @author Fordring
 * @date 2016/08/30
 * @version V1.0
 */
@Controller
public class DF010004Controller {
	private static final Logger logger = LoggerFactory.getLogger(DF010004Controller.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/search/pageNum/{pageNum}/detail.html", method = { RequestMethod.GET })
	public String searchBook(@PathVariable("pageNum") String pageNum, HttpServletRequest request,
			Map<String, Object> result) {
		if (pageNum == null || "".equals(pageNum.trim())) {
			pageNum = "0";
		}
		String search = request.getParameter("searchContent");
		logger.info("search:" + search);
		// 首页小说
		List<Map<String, Object>> homeBooks = sqlSession.selectList("t_book_info.findByShowHomePage");
		List<Map<String, Object>> bookList = new ArrayList<>();
		int count = 0;
		// （临时）过滤掉sql注入攻击
		if (search.length() < 16) {
			Map<String, Object> param = new HashMap<>();
			param.put("search", search);
			param.put("start", (Integer.valueOf(pageNum) * 20));
			bookList = sqlSession.selectList("t_book_info.findByBookNameLikeOrBookAuthLike", param);
			count = sqlSession.selectOne("t_book_info.countByBookNameLikeOrBookAuthLike", param);
			int previousPageNum = 0;
			int nextPageNum;
			if ("0".equals(pageNum)) {
				nextPageNum = 1;
			} else {
				previousPageNum = Integer.valueOf(pageNum) - 1;
				nextPageNum = Integer.valueOf(pageNum) + 1;
			}
			result.put("previousPageNum", previousPageNum);
			result.put("currentPageNum", pageNum);
			result.put("nextPageNum", nextPageNum);
		}
		result.put("height", 100 + 140 * bookList.size());
		result.put("bookList", bookList);
		result.put("searchText", search);
		result.put("bookSize", count);
		result.put("homeBooks", homeBooks);
		return "search";
	}

}
