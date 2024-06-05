package com.kunling.spring6.autowired.controller;

import com.kunling.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    // 注入Service
    // 第一种方式：属性注入
//    @Autowired  // 根据类型找到对应的对象，完成对象
//    private UserService userService;

    // 第二种方式：set方法注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 第三种方式：构造方法注入
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 第四种方式：形参上注入
//    private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    // 第五种方式：只有一个有参数构造，可以不加注解
//    private UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 第六种方式：使用两个注解根据名称进行注入
    @Autowired
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    public void add() {
        System.out.println("controller......");
        userService.add();
    }
}
