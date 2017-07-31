package com.ifly.edu.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pangzhw
 * @date 2015年3月26日
 */
public class RegexTest {

	 public static void main(String[] args) {
		
		 String name ="aa/rzrq_10342_2.txt";
		 
		 Pattern p = Pattern.compile("^rzrq_10342_\\d+.txt$");
		 Matcher m = p.matcher(name);
		 boolean b = m.matches();
	        
		 System.out.println(b);
		 
		 System.out.println(name.matches("^rzrq_10342_\\d+.txt$"));
		 
		 System.out.println(name.substring(name.lastIndexOf("/")+1));
	}
}
