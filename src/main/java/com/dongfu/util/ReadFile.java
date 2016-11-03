package com.dongfu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fordring on 2016/7/30.
 */
public class ReadFile {

	public static Map<String, String> readTxtFileByLine(String filePath) {
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt;
				StringBuilder sb = new StringBuilder();
				StringBuilder description = new StringBuilder();
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!"".equals(lineTxt.trim())) {
						String temp = lineTxt.trim().replaceAll("\\u00A0", "");
						sb.append("<p class='pcontent'>" + temp + "</p>");
						description.append(temp);
					}
				}
				read.close();
				Map<String, String> map = new HashMap<String, String>(4);
				map.put("newContent", sb.toString());
				map.put("description", description.toString());
				return map;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错！");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String argv[]) {
		String filePath = "E:\\mnt\\staticfiles\\novel\\1467940833017\\1467954639900.txt";
		System.out.println(readTxtFileByLine(filePath));
	}
}
