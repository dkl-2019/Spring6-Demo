package com.kunling.spring6.iocxml.life;

public class User {

    public User() {
        System.out.println("1 调用User无参构造，创建bean对象");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2 给bean对象设置属性值");
        this.name = name;
    }
    // 初始化方法
    public void initMethod() {
        System.out.println("4 bean对象初始化，调用初始化方法");
    }
    // 销毁方法
    public void destoryMethod() {
        System.out.println("7 bean对象销毁，调用销毁方法");
    }

}
