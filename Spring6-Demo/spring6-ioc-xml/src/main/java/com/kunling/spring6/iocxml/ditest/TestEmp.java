package com.kunling.spring6.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {

    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");
        // 员工的对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();

    }

}
