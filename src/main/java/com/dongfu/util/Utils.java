package com.dongfu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fordring on 2016/9/1.
 */
public class Utils {

	// 快速翻页功能
	public static List<Map<String, Object>> getGroup(int count) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int page = 20;
		if (count <= 20) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 0);
			map.put("value", "1-" + count);
			list.add(map);
			return list;
		}
		int temp = count / page;
		for (int i = 0; i < temp; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", i);
			map.put("value", i * page + 1 + "-" + page * (i + 1));
			list.add(map);
		}
		if (count % page != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", temp);
			map.put("value", temp * page + 1 + "-" + count);
			list.add(map);
		}
		return list;
	}

	/**
	 * 获取访问者的IP
	 * 
	 * @param request
	 * @return 返回访问者的IP地址，特别是启用CDN后改地址比较长
	 */
	public static String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 得到MD5加密后的密文
	 * 
	 * @param pwd
	 * @return 加密后的密文
	 */
	public static String getPwdForMD5(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());
			byte[] b = md.digest();
			int i = 0;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (0 < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.getStackTrace();
		}
		return null;
	}

}
