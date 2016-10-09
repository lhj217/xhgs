package com.dongfu.controller;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: DF010003Controller
 * @Description: 查询排名信息
 * @author Fordring
 * @date 2016/08/29
 * @version V1.0
 */
@Controller
public class DF010003Controller {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@RequestMapping(value = "/ranking.html", method = { RequestMethod.GET })
	public String ranking(Map<String, Object> result) {
		List<Map<String, Object>> dayBooks = sqlSession.selectList("t_book_info.findByOrderByReadDayCount");
		List<Map<String, Object>> weekBooks = sqlSession.selectList("t_book_info.findByOrderByReadWeekCount");
		List<Map<String, Object>> monthBooks = sqlSession.selectList("t_book_info.findByOrderByReadMonthCount");
		List<Map<String, Object>> countBooks = sqlSession.selectList("t_book_info.findByOrderByReadCount");
		result.put("dayBooks", dayBooks);
		result.put("weekBooks", weekBooks);
		result.put("monthBooks", monthBooks);
		result.put("countBooks", countBooks);
		result.put("active", "2");
		return "ranking";
	}
}
