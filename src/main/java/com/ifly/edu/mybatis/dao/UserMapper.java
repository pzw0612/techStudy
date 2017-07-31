package com.ifly.edu.mybatis.dao;

import java.util.List;

import com.ifly.edu.mybatis.bean.User;

/**
 *
 * @author pangzhw
 * @date 2015年5月13日
 */
public interface UserMapper {  
    public List<User> findByName(String name);  
    public void insertUser(User user);  
} 
