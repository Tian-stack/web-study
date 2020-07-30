package com.tian.dao;

import com.tian.pojo.User;
import com.tian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        UserDAO userDao = sqlSession.getMapper(UserDAO.class);

        List<User> users = userDao.getUserList();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDAO mapper = sqlSession.getMapper(UserDAO.class);

        User user1 = mapper.getUserById(2);
        System.out.println(user1);
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO mapper = sqlSession.getMapper(UserDAO.class);
        int num = mapper.addUser(new User(4, "田甜2号", "123456"));
        if(num>0){
            System.out.println("插入成功！！！");
        }
        //事务，提交事务
        sqlSession.commit();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO mapper = sqlSession.getMapper(UserDAO.class);
        int num = mapper.updateUser(new User(4, "田甜3号", "654321"));
        System.out.println(num);
        sqlSession.commit();
    }

    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO mapper = sqlSession.getMapper(UserDAO.class);
        int num = mapper.deleteUserById(4);
        System.out.println(num);
        sqlSession.commit();
    }
}
