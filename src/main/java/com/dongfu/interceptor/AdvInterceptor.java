package com.dongfu.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: AdvInterceptor
 * @Description: 广告拦截器
 * @author Fordring
 * @date 2016/09/16
 * @version V1.0
 */
public class AdvInterceptor implements HandlerInterceptor {

	public static Logger logger = LoggerFactory.getLogger(AdvInterceptor.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
//		List<Map<String, Object>> advs = sqlSession.selectList("t_adv_info.findByIsValid");
//		request.setAttribute("adv", advs.get(0).get("adv_code"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}
}