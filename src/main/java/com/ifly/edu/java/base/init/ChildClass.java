package com.ifly.edu.java.base.init;

/**
 *
 * @author pangzhw
 * @date 2015年5月17日
 */
public class ChildClass extends FatherClass {

	public ChildClass() {
		System.out.println("ChildClass Create");
	}

	public static void main(String[] args) {
		FatherClass fc = new FatherClass();
		ChildClass fc2 = new ChildClass();
	}
}
