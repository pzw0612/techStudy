package com.ifly.edu.java;

import java.math.BigDecimal;

/**
 * @ClassName: DigitstTest
 * @Description: TODO
 * @author pangzhw
 * @date 2015年1月15日
 */
public class DigitstTest {
public static void main(String[] args) {
	System.out.println(Integer.valueOf(String.valueOf(1100))/1000 *1000);
	
	BigDecimal a = new BigDecimal(1);
	BigDecimal b = new BigDecimal(2);
	System.out.println(a.compareTo(b));
}
}
