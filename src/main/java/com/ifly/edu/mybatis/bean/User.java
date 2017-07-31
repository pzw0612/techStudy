package com.ifly.edu.mybatis.bean;

import java.io.Serializable;

/**
 *
 * @author pangzhw
 * @date 2015年5月13日
 */

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User() {
	}
}
