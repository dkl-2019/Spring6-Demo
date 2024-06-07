package com.kunling.service.impl;

import com.kunling.anno.Bean;
import com.kunling.anno.Di;
import com.kunling.dao.UserDao;
import com.kunling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

}
