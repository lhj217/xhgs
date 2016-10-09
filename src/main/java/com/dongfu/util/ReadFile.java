package com.dongfu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Fordring on 2016/7/30.
 */
public class ReadFile {

	public static String readTxtFileByLine(String filePath) {
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt;
				StringBuilder sb = new StringBuilder();
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!"".equals(lineTxt.trim())) {
						// sb.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;" + lineTxt +
						// "</p>");
						String temp = lineTxt.trim().replaceAll("\\u00A0", "");
						sb.append("<p class='pcontent'>" + temp + "</p>");
					}
				}
				read.close();
				return sb.toString();
			} else {
				return "章节内容暂不存在！";
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错！");
			e.printStackTrace();
		}
		return "系统异常，请稍后重试！";
	}

	public static void main(String argv[]) {
		String filePath = "E:\\mnt\\staticfiles\\novel\\1467940833017\\1467954639900.txt";
		System.out.println(readTxtFileByLine(filePath));
	}
}
