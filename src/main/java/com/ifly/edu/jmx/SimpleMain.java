package com.ifly.edu.jmx;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMain {
  
	 public static void main(String[] args)  throws Exception{
		new ClassPathXmlApplicationContext(new String[]{"simple-jmx-context.xml"},SimpleMain.class);
        new BufferedReader(new InputStreamReader(System.in)).readLine();
	 }
}
