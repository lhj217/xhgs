package com.dongfu.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dongfu.util.Constant;
import com.dongfu.util.DateUtil;
import com.dongfu.util.Utils;

/**
 * @ClassName: CommonInterceptor
 * @Description: 公共拦截器
 * @author Fordring
 * @date 2016/09/14
 * @version V1.0
 */
public class CommonInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");// 允许哪些url可以跨域请求到本域
		response.setHeader("Access-Control-Allow-Methods", "POST");// 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,accept");// 允许哪些请求头可以跨域
		response.addHeader("Access-Control-Max-Age", "60");
		logger.info("<--------------------------------------------------------------->");
		logger.info("request url-->" + request.getRequestURL());
		String remoteIp = Utils.getRemoteHost(request);
		logger.info("request  ip-->:" + remoteIp);
		if ("http://121.42.203.194:57810/404.html".equals(request.getRequestURL().toString())) {
			logger.info("visit url is Invalid");
		} else if ("127.0.0.1".indexOf(remoteIp) < 0) {
			Map<String, Object> remoteMap = new HashMap<String, Object>(3);
			remoteMap.put("visitId", System.currentTimeMillis());
			remoteMap.put("visitIp", remoteIp);
			remoteMap.put("visitTime", DateUtil.getNowDate(DateUtil.SDF2));
			remoteMap.put("visitUrl", request.getRequestURL().toString());
			sqlSession.insert("t_visit_log.insert", remoteMap);
		} else {
			logger.info("Is local visit");
		}
		request.setAttribute("website", Constant.WEBSITE_URL);
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView)
			throws Exception {
		if (request.getParameter("active") == null || "".equals(request.getParameter("active").trim())) {
			request.setAttribute("active", "0");
		}
		request.setCharacterEncoding("UTF-8");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		// logger.info("<-------------------------------------------------------------------->");
	}
}
