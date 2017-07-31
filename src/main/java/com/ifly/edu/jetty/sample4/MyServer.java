package com.ifly.edu.jetty.sample4;

import org.springframework.context.support.ClassPathXmlApplicationContext;  

public class MyServer {  
    public static void main(String[] args) throws Exception {  
        new ClassPathXmlApplicationContext("/com/ifly/code/pangzhw/jettystudy/sample4/spring.xml");  
    }  
}
