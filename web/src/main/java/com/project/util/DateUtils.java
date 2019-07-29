package com.project.util;

import java.text.SimpleDateFormat;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-26 .
 */
public class DateUtils {

	/**
	 * Z时间转UTC.
	 * @param date 参数时间.
	 * @return String 返回转换后的时间字符串.
	 * */
	public String transferDateZ2UTC(String date) {
		date = date.replace("Z", " UTC");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format2.format(format1.parse(date));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}
