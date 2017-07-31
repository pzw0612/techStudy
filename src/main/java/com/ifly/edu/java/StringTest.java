package com.ifly.edu.java;

import org.apache.tools.zip.*; 
import java.util.Enumeration; 
/**
 * @ClassName: StringTest
 * @Description: TODO
 * @author pangzhw
 * @date 2015年1月14日
 */
public class StringTest {

	public static void main(String[] args) {
		
		
		String st="*****D890825260A738636000010001         ***********MMM08916|093001|22170|A10000";
		//股东卡号
		System.out.println(st.substring(5, 15));
		
		//股票代码
		System.out.println(st.substring(16, 22));
		
		//议案号
		System.out.println(st.substring(22, 30));
		
		//议案意见
		System.out.println(st.substring(30, 31));
		
		//普通议案代表股权数
		System.out.println(st.substring(73));
		
		//投票时间
		System.out.println(st.substring(60,66));
		
		
		
	   System.out.println("    aaa".trim());
	}
}
