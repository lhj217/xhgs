package com.dongfu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @ClassName: DateUtil
 * @Description: TODO
 * @author Fordring
 * @date 2016年9月14日 下午3:18:25
 * @version V1.0
 */
public class DateUtil {
	public static final String SDF1 = "yyyy/MM/dd HH:mm:ss";

	public static final String SDF2 = "yyyy-MM-dd HH:mm:ss";

	public static final String SDF3 = "yyyyMMdd";

	public static final String SDF4 = "HHmmss";

	/**
	 * 获取指定格式的当前日期
	 * 
	 * @param pattern
	 * @return 返回指定格式的当前日期
	 */
	public static String getNowDate(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}

}
