package com.kunling.spring6.autowired.service;

import com.kunling.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    // 注入dao
    // 第一种方式：属性注入
//    @Autowired  // 根据类型找到对应的对象，完成注入
//    private UserDao userDao;

    // 第二种方式：set方法注入
//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第三种方式：构造方法注入
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第四种方式：形参上注入
//    private UserDao userDao;
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第五种方式：只有一个有参数构造，可以不加注解
//    private UserDao userDao;
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第六种方式：使用两个注解根据名称进行注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service......");
        userDao.add();
    }
}
