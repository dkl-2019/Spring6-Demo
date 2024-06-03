package com.kunling.spring6.iocxml.ditest;

// 员工类
public class Emp {

    // 对象类型属性：员工属于某个部门
    private Dept dept;
    // 员工名称
    private String ename;
    // 员工年龄
    private Integer age;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void work() {
        System.out.println(ename + "emp work..." + age);
    }
}
