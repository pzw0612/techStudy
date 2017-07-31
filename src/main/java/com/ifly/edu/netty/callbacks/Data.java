package com.ifly.edu.netty.callbacks;

/**
 *
 * @author pangzhw
 * @date 2015年7月8日
 */
public class Data {

	private int n;
	private int m; 
	public Data(int n,int m){
		this.n= n;
		this.m= m;
	}
	
	public String toString() { 
		int r = n/m;
		return n + "/"+ m +"= "+ r;
	}
}
