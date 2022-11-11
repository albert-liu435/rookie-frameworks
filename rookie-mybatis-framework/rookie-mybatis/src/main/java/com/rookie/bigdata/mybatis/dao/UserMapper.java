package com.rookie.bigdata.mybatis.dao;

import com.rookie.bigdata.mybatis.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/11 0:09
 * @Version 1.0
 */
public interface UserMapper {

    public List<User> findAll() throws IOException;

    public User findById(int id);

}

