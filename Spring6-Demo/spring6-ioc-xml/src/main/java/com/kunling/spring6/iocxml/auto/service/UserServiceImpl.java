package com.kunling.spring6.iocxml.auto.service;

import com.kunling.spring6.iocxml.auto.dao.UserDao;
import com.kunling.spring6.iocxml.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserService的方法执行了...");
        userDao.addUserDao();
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }
}
