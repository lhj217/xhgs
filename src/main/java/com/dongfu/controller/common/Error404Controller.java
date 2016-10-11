package com.dongfu.controller.common;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: Error404Controller
 * @Description: 404统一处理
 * @author Fordring
 * @date 2016年10月11日 上午10:45:32
 * @version V1.0
 */
@Controller
class Error404Controller {

	@RequestMapping(value = "/404", method = { RequestMethod.GET })
	public String index(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return "common/404";
	}
}
