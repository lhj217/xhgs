package com.dongfu.util;

import java.util.List;
import java.util.Map;

/**
 * 系统常量
 * 
 * @ClassName: Constant
 * @Description: TODO
 * @author Fordring
 * @date 2016年9月10日 下午4:03:52
 * @version V1.0
 */
public class Constant {
	// 域名地址
	public static String WEBSITE_URL = "http://m.xdhtxt.com";
	// public static String WEBSITE_URL = "http://localhost:8080";

	// 封面url前缀
	public static String PIC_URL_PREFIX = "/novelcover/";

	// 图片类型
	public static enum PIC_TYPE {
		JPG, PNG
	}

	// 查询IP地址的网站
	public static String IP_WEBSITE_URL = "http://ip.taobao.com/service/getIpInfo.php?ip={ip}";

	// SEO信息
	public static List<Map<String, Object>> seoParams = null;

	// 文件存放根目录
	public static String BOOK_BASE_DIR = "/mnt/staticfiles/novel/";

	// 编码格式
	public static String ENCODING = "UTF-8";
}
