package com.zcl;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期测试类
 *
 * @author zhanghao10@jd.com
 * @since 2016/3/18 0018
 */

public class DateTest {

	/**
	 * 使用Calendar类 辅助完成天数的差值
	 * 在不涉及到跨年的情况，此种方法是没问题的
	 * 但是设计跨年的情况，此种方法回出问题的哦
	 * <p>
	 * 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 1
	 *
	 * @throws ParseException .
	 */
	@Test
	public void daysOfTwo_1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//跨年的情况会出现问题哦
		//如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 1
		Date fDate = sdf.parse("2015-12-31");
		Date oDate = sdf.parse("2016-01-01");
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(oDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		int days = day2 - day1;
		System.out.print(days);
	}

	/**
	 * 通过毫秒值，手动计算日期间的相关的值
	 * <p>
	 * 跨年不会出现问题
	 * 使用此种方法的话需要注意
	 * 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
	 *
	 * @throws ParseException .
	 */
	@Test
	public void daysOfTwo_2() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//跨年不会出现问题
		//如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
		Date fDate = sdf.parse("2015-12-31");
		Date oDate = sdf.parse("2016-01-01");
		long days = (oDate.getTime() - fDate.getTime()) / (1000 * 3600 * 24);
		System.out.print(days);
	}
}

