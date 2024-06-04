package com.kunling.spring6.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDept {

    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diList.xml");
        // 员工的对象
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();

    }

}
