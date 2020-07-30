package com.tian.dao;

import com.tian.pojo.User;

import java.util.List;

public interface UserDAO {
    //查询所有用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //增加一个用户
    int addUser(User user);

    //修改一个用户
    int  updateUser(User user);

    //删除一个用户（根据id）
    int deleteUserById(int id);
}
