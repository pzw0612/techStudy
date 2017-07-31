package com.ifly.edu.java.annotation;


import java.lang.annotation.*;


/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}
