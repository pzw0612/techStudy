package com.ifly.edu.netty.codeC;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 *
 * @author pangzhw
 * @date 2015年7月13日
 */
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String userName;
	
	private int userID;
	
	public UserInfo buildUserName(String userName){
		this.userName = userName;
		return this;
	}
	
	public UserInfo buildUserID(int userID){
		this.userID = userID;
		return this;
	}
	
	public String getUserName(){
		return this.userName;
	}
	public int getUserID(){
		return this.userID;
	}
	
	public void setUserName(String userName){
		 this.userName = userName;
	}
	
	public void setUserID(int userID){
		 this.userID = userID;
	}
	
	public byte[] codeC(){
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		
		buffer.putInt(this.userID);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		
		buffer.get(result);
		
		return result;
	}
}
