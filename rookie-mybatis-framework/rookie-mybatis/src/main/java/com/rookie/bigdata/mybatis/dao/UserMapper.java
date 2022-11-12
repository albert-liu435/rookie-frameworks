package com.rookie.bigdata.mybatis.dao;

import com.rookie.bigdata.mybatis.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserMapper
 * @Description
 * @Author rookie
 * @Date 2022/11/11 0:09
 * @Version 1.0
 */
public interface UserMapper {

    public List<User> findAll() throws IOException;

    public User findById(int id);


    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);


    public void save4(User user);

    public User findById4(int id);

    public List<User> findAll4();


    public List<User> findAll5();

    public List<User> findUserAndRoleAll5();


}

