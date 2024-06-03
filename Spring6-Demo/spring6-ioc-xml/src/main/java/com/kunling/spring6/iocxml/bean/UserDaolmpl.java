package com.kunling.spring6.iocxml.bean;

public class UserDaolmpl implements UserDao{
    @Override
    public void run() {
        System.out.println("run...");
    }
}
