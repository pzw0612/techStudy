package com.ifly.edu.java.cls;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月15日
 */
public class ClassA<T> {
	private T obj;

	public void setObject(T obj) {
		this.obj = obj;
	}

	public T getObject() {
		return obj;
	}
}
