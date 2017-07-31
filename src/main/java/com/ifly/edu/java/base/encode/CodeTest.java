package com.ifly.edu.java.base.encode;

/**
 *
 * @author pangzhw
 * @date 2015年5月17日
 */
public class CodeTest {

	public static void split(String source, int num) throws Exception {
		int k = 0;
		String temp = "";
		for (int i = 0; i < source.length(); i++) {
			byte[] b = (source.charAt(i) + "").getBytes();
			k = k + b.length;
			if (k > num) {
				break;
			}
			temp = temp + source.charAt(i);
		}
		System.out.println(temp);
	}
	public static void main(String[] args) throws Exception {
		split("我 ABC",4);
		
		System.out.println("我 ABC".substring(0,4));
		System.out.println("我 ABC 汉 DEF".substring(0,6));
	}
}
