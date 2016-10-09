package com.dongfu.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongfu.util.BookType;
import com.dongfu.util.Utils;

/**
 * @ClassName: DF010002Controller
 * @Description: 查询不同类目下的书籍列表
 * @author Fordring
 * @date 2016/08/29
 * @version V1.0
 */
@Controller
public class DF010002Controller {
	private static final Logger logger = LoggerFactory.getLogger(DF010002Controller.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/category/{bookType}/{pageNum}.html", method = { RequestMethod.GET })
	public String classification(@PathVariable("bookType") String bookType, @PathVariable("pageNum") String pageNum,
			Map<String, Object> result) throws UnsupportedEncodingException {
		logger.info("bookType:" + bookType + ";pageNum:" + pageNum);
		List<Map<String, Object>> bookList;
		String page = "over";
		Map<String, Object> param = new HashMap<>();
		if ("99".equals(bookType)) {
			// 查询完本小说
			param.put("bookIsOver", "1");
			param.put("start", (Integer.valueOf(pageNum) * 20));
			bookList = sqlSession.selectList("t_book_info.findByBookBookIsOver", param);
			int previousPageNum = 0;
			int nextPageNum;
			if ("0".equals(pageNum)) {
				nextPageNum = 1;
			} else {
				previousPageNum = Integer.valueOf(pageNum) - 1;
				nextPageNum = Integer.valueOf(pageNum) + 1;
			}
			int count = sqlSession.selectOne("t_book_info.countByBookType", param);
			List<Map<String, Object>> list = Utils.getGroup(count);
			result.put("groups", list);
			result.put("currentPageNum", pageNum);
			result.put("previousPageNum", previousPageNum);
			result.put("nextPageNum", nextPageNum);
			result.put("typeName", BookType.getBookTypeName("10"));
			result.put("bookType", "99");
			result.put("active", "3");
		} else if ("88".equals(bookType)) {
			bookList = null;
			page = "category";
			result.put("active", "1");
		} else {
			param.put("book_type", bookType);
			param.put("start", (Integer.valueOf(pageNum) * 20));
			bookList = sqlSession.selectList("t_book_info.findByBookType", param);
			int previousPageNum = 0;
			int nextPageNum;
			if ("0".equals(pageNum)) {
				nextPageNum = 1;
			} else {
				previousPageNum = Integer.valueOf(pageNum) - 1;
				nextPageNum = Integer.valueOf(pageNum) + 1;
			}
			int count = sqlSession.selectOne("t_book_info.countByBookType", param);
			List<Map<String, Object>> list = Utils.getGroup(count);
			result.put("groups", list);
			result.put("currentPageNum", pageNum);
			result.put("previousPageNum", previousPageNum);
			result.put("nextPageNum", nextPageNum);
			result.put("typeName", BookType.getBookTypeName(bookType));
			result.put("bookType", bookType);
			result.put("active", "1");
		}
		result.put("bookList", bookList);
		return page;
	}

}
