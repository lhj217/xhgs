package com.dongfu.controller.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dongfu.util.Constant;

/**
 * 项目预加在SEO信息到内存中
 * @ClassName: InitCommDataServlet
 * @Description: TODO
 * @author Fordring
 * @date 2016年10月13日 下午2:54:45
 * @version V1.0
 */
public class InitCommDataServlet extends HttpServlet {

	private static final long serialVersionUID = -4523415471892457451L;

	private static final Logger logger = LoggerFactory.getLogger(InitCommDataServlet.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void init() throws ServletException {
		logger.info("servlet init ....");
		super.init();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		sqlSession = (SqlSessionTemplate) wac.getBean("sqlSession");
		Constant.seoParams = sqlSession.selectList("t_sys_param.findBy");
	}
}
