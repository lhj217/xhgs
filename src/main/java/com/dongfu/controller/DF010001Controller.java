package com.dongfu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: DF010001Controller
 * @Description: 首页请求服务
 * @author Fordring
 * @date 2016/08/26 16:03:52
 * @version V1.0
 */
@Controller
class DF010001Controller {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index(Map<String, Object> result) throws UnsupportedEncodingException {
		// 首页小说
		List<Map<String, Object>> homeBooks = sqlSession.selectList("t_book_info.findByShowHomePage");
		// 首页热门小说
		List<Map<String, Object>> hotBooks = sqlSession.selectList("t_book_info.findByIsHot");
		// 最近更新的小说
		List<Map<String, Object>> updateBooks = sqlSession.selectList("t_book_info.findByOrderByBookUpdateTime");
		// 友情链接
		// List<Map<String, Object>> friendLinks =
		// sqlSession.selectList("t_friends_link.findByIsValid");
		// result.put("friendLinks", friendLinks);
		result.put("homeBooks", homeBooks);
		result.put("hotBooks", hotBooks);
		result.put("updateBooks", updateBooks);
		return "index";
	}
}
