package com.ifly.edu.HttpClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	//private static final Pattern number = Pattern.compile("$(<h1 class)(</h1><span)$");
	
	public static void main(String[] args) {
		
		
	String  str = "<h1 class关于就《上海证券交易所、中国证券登记结算有限责任公司股票期权试点风险控制管理办法（征求意见稿）》公开征求意见的通知</h1><span";

	int start = str.indexOf("<h1 class");
	int end = str.indexOf("</h1><span");
	
	System.out.println(str.substring(start+"<h1 class".length(), end));
	}
}
