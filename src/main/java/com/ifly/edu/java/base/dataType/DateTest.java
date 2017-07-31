package com.ifly.edu.java.base.dataType;

import java.util.Calendar;

/**
 *
 * @author pangzhw
 * @date 2015年5月17日
 */
public class DateTest {

	public static void main(String[] args) {
		testLastOfMonth();

		short s1 = 1; s1 += 1;
		
	}
	/**
	 * 判断当月的最后一天
	 */
	public static void testLastOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,2004);
		c.set(Calendar.MONTH,0);
		c.set(Calendar.DAY_OF_MONTH,31);
		Calendar c1 = (Calendar) c.clone();

		c.add(Calendar.DAY_OF_MONTH, 1);
		if (c.get(Calendar.MONTH) != c1.get(Calendar.MONTH)) {
			System.out.println("是最后一天");
		} else {
			System.out.println("不是取后一天");
		}
	}
}
