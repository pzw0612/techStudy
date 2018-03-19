package com.ifly.edu.hessian.hello;

import java.net.MalformedURLException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HessianServiceTest {    
    @SuppressWarnings("resource")

    public void testService() throws MalformedURLException {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "config/hessian/hessian-client.xml");
        HelloService hello = (HelloService) context.getBean("hessianClient");
        System.out.println(hello.sayHello("pangzhw"));
    }
}
