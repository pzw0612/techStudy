package com.ifly.edu.hessian.hello;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String message) {
        return "hello," + message;
    }
}
