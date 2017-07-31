package com.ifly.edu.hessian.hello;

import java.net.MalformedURLException;

import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;

public class ServiceTest {

    @Test
    public void testService() throws MalformedURLException {        

        String url = "http://localhost:8080/techStudy/hessian/service";
        System.out.println(url);
        
        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService helloService = (HelloService) factory.create(HelloService.class, url);
        System.out.println(helloService.sayHello("pangzhw"));

    }
}
