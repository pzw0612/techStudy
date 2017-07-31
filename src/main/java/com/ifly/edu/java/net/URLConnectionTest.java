package com.ifly.edu.java.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *URLConnection 测试
 * @author pangzhw
 * @date 2015年4月6日
 */
public class URLConnectionTest {

	public static void main(String[] args) throws Exception {
		localFileReq();
	}
	
	
	/**
	 * get请求
	 */
	static void getReq() throws Exception{
		URL url = new URL("http://jenkov.com");
		URLConnection urlConnection = url.openConnection();
		InputStream input = urlConnection.getInputStream();
		int data = input.read();
		while(data != -1){
		System.out.print((char) data);
		data = input.read();
		}
		input.close();
	}
	/**
	 * post 请求
	 */
	static void postReq() throws Exception{
		URL url = new URL("http://jenkov.com");
		URLConnection urlConnection = url.openConnection();
		InputStream input = urlConnection.getInputStream();
		urlConnection.setDoOutput(true);
		OutputStream output = urlConnection.getOutputStream();
		int data = input.read();
		while(data != -1){
			System.out.print((char) data);
			data = input.read();
		}
		input.close();
	}
	/**
	 * 从URLs到本地文件
	 */
	static void localFileReq() throws Exception{
		URL url = new URL("file:/E:/data/urlConnection.txt");
		URLConnection urlConnection = url.openConnection();
		InputStream input = urlConnection.getInputStream();
		int data = input.read();
		while(data != -1){
		System.out.print((char) data);
		data = input.read();
		}
		input.close();
	}
}
