package com.kunling.spring6.iocxml.auto.controller;

import com.kunling.spring6.iocxml.auto.service.UserService;
import com.kunling.spring6.iocxml.auto.service.UserServiceImpl;

public class UserController {

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("controller中的方法执行了...");
        //调用service的方法
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }

}
