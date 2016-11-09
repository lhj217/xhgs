package com.dongfu.controller.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfu.util.Constant;

/**
 * APP首页交易
 * 
 * @ClassName NRS0001Controller.java
 * @Description TODO
 * @Author Fordring
 * @Date 2016年11月6日
 * @Version V1.0
 */
@Controller
@RequestMapping("/app")
public class NRS0001Controller {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@ResponseBody
	@RequestMapping(value = "/NRS0001", method = { RequestMethod.GET })
	public Map<String, Object> XFS0001() {
		Map<String, Object> result = new HashMap<String, Object>(5);
		// 首页小说
		List<Map<String, Object>> homeBooks = sqlSession.selectList("t_book_info.findByShowHomePage");
		for (Map<String, Object> map : homeBooks) {
			map.put("book_cover_url", Constant.WEBSITE_URL + Constant.PIC_URL_PREFIX + map.get("book_id") + "."
					+ (Constant.PIC_TYPE.JPG + "").toLowerCase());
		}
		result.put("books", homeBooks);
		return result;
	}

}
