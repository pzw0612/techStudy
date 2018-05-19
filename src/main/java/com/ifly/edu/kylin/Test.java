package com.ifly.edu.kylin;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/4/30
 **/
public class Test {

    public static void main(String[] args) {

        byte[] key = ("ADMIN"+":"+"KYLIN").getBytes();
        String encoding = Base64.encodeBase64String(key);
        System.out.println(encoding);
    }
}
