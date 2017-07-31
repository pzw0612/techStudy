package com.ifly.edu.jackson.test;

import java.util.ArrayList;
import java.util.List;

import com.ifly.edu.jackson.common.JsonUtils;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年3月4日
 */
public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<Student>();
		
		stuList.add(new Student("zhangshan","一班",20));
		stuList.add(new Student("lisi","2班",20));
		stuList.add(new Student("wanwu","3班",20));
		
		System.out.println(JsonUtils.toJsonString(stuList));
	}

}


class Student{
	String name;
	String cls;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param name
	 * @param cls
	 * @param age
	 */
	public Student(String name, String cls, int age) {
		super();
		this.name = name;
		this.cls = cls;
		this.age = age;
	}
	
}
