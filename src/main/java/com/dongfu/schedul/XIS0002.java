package com.dongfu.schedul;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dongfu.util.Constant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class XIS0002 {

	private static final Logger logger = LoggerFactory.getLogger(XIS0002.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 更新访客的地址(一小时更新一次)
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@Scheduled(cron = "0 0 * * * *")
	public void updateVisitInfo() throws JsonParseException, JsonMappingException, IOException {
		logger.info("<------------- 更新访客的地址开始 ------------->");
		List<Map<String, Object>> resultList = this.sqlSession.selectList("t_visit_log.findByVisitorsAddrIsNull");
		for (Map<String, Object> map : resultList) {
			String remoteIP = (map.get("visit_ip") + "").trim();
			String ip = remoteIP.indexOf(",") > 0 ? remoteIP.substring(0, remoteIP.indexOf(",")) : remoteIP;
			String remoteAddr = "";
			if ("127.0.0.1".indexOf(remoteIP) != -1) {
				remoteAddr = "本地访问";
			} else {
				RestTemplate restTemplate = new RestTemplate();
				String restInfo = restTemplate.getForObject(Constant.IP_WEBSITE_URL, String.class, ip);
				logger.info(restInfo);
				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> ipInfo = mapper.readValue(restInfo, Map.class);
				// trade success
				if ("0".equals(ipInfo.get("code") + "")) {
					logger.info("query ip address success!");
					Map<String, Object> data = (Map<String, Object>) ipInfo.get("data");
					remoteAddr = data.get("isp") + "-" + data.get("country") + data.get("area") + data.get("region")
							+ data.get("city");
					logger.info("ip:" + ip + " " + remoteAddr);
					Map<String, Object> param = new HashMap<String, Object>(4);
					param.put("visitIp", remoteIP);
					param.put("visitorsAddr", remoteAddr);
					sqlSession.update("t_visit_log.updateVisitLog", param);
				} else {
					logger.info("query ip address fail!");
				}
			}
		}
		logger.info("<------------- 更新访客的地址结束 ------------->");
	}
}
