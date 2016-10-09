package com.dongfu.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: SeoInterceptor
 * @Description: SEO拦截器
 * @author Fordring
 * @date 2016/09/16
 * @version V1.0
 */
public class SeoInterceptor implements HandlerInterceptor {

	// private static Logger logger =
	// LoggerFactory.getLogger(SeoInterceptor.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String requestURL = request.getRequestURL() + "";
		List<Map<String, Object>> sysParams = new ArrayList<Map<String, Object>>();
		String title = "";
		String keywords = "";
		String description = "";
		if (requestURL.indexOf(".html") == -1) {
			sysParams = sqlSession.selectList("t_sys_param.findBy");
			// 首页请求
			for (int i = 0; i < sysParams.size(); i++) {
				Map<String, Object> sysParam = sysParams.get(i);
				if ("home_title".equals(sysParam.get("param_key") + "")) {
					title = sysParam.get("param_value") + "";
				}
				if ("home_keywords".equals(sysParam.get("param_key") + "")) {
					keywords = sysParam.get("param_value") + "";
				}
				if ("home_description".equals(sysParam.get("param_key") + "")) {
					description = sysParam.get("param_value") + "";
				}
			}
		} else if ("/bookInfo/".indexOf(requestURL) > 0) {
			// 小说详情
			// for (int i = 0; i < sysParams.size(); i++) {
			// Map<String, Object> sysParam = sysParams.get(i);
			// if ("book_info_title".equals(sysParam.get("param_key") + "")) {
			// title = (sysParam.get("param_value") + "").replaceAll("bookName",
			// bookInfo.get("book_name") + "").replace("bookAuth",
			// bookInfo.get("book_auth") + "");
			// }
			// if ("book_info_keywords".equals(sysParam.get("param_key") + ""))
			// {
			// keywords = (sysParam.get("param_value") +
			// "").replaceAll("bookName", bookInfo.get("book_name") + "");
			// }
			// if ("book_info_description".equals(sysParam.get("param_key") +
			// "")) {
			// description = (sysParam.get("param_value") +
			// "").replaceAll("bookName", bookInfo.get("book_name") + "");
			// }
			// }
		}
		// seo信息
		Map<String, Object> seo = new HashMap<>();
		seo.put("title", title);
		seo.put("keywords", keywords);
		seo.put("description", description);
		request.setAttribute("seo", seo);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> seo = (Map<String, Object>) request.getAttribute("seo");
		if (seo == null || seo.get("title") == null || "".equals((seo.get("title") + "").trim())) {
			List<Map<String, Object>> sysParams = new ArrayList<Map<String, Object>>();
			String title = "";
			String keywords = "";
			String description = "";
			sysParams = sqlSession.selectList("t_sys_param.findBy");
			// 首页请求
			for (int i = 0; i < sysParams.size(); i++) {
				Map<String, Object> sysParam = sysParams.get(i);
				if ("home_title".equals(sysParam.get("param_key") + "")) {
					title = sysParam.get("param_value") + "";
				}
				if ("home_keywords".equals(sysParam.get("param_key") + "")) {
					keywords = sysParam.get("param_value") + "";
				}
				if ("home_description".equals(sysParam.get("param_key") + "")) {
					description = sysParam.get("param_value") + "";
				}
			}
			seo.put("title", title);
			seo.put("keywords", keywords);
			seo.put("description", description);
			request.setAttribute("seo", seo);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}
}