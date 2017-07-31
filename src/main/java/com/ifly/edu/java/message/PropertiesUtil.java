package com.ifly.edu.java.message;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
	private static ResourceBundle rb;

	static {
		rb = ResourceBundle.getBundle("config",Locale.CHINA);
	}


	/**
	 * 长连接请求
	 */
	public static String getMsUrl(){
		return rb.getString("MS_URL");
	}


	

	public static void main(String[] args) {
//		MessageFormat myFormat=new MessageFormat( getMsUrl()); 
//
//		System.out.println(myFormat.format(new Object[]{1l,"122"}));
		
	
			try {
				System.out.println(new String(rb.getString("txt_file_path").getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}