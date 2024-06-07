package com.kunling.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {

    // 1. 通过反射获取class对象的方式
    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 通过 类名.class
        Class clazz1 = Car.class;
        // 2. 通过 对象.getClass()
        Class clazz2 = new Car().getClass();
        // 3. 通过 Class.forName("类全路径")
        Class clazz3 = Class.forName("com.kunling.reflect.Car");
        // 实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }


    // 2. 通过反射获取构造方法
    @Test
    public void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Car.class;
        // 获取所有构造
//        Constructor[] constructors = clazz.getConstructors();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c :
                declaredConstructors) {
            System.out.println("构造方法名称："+c.getName()+ " 参数个数："+ c.getParameterCount());
        }

        // 指定有参数构造创建对象
        // 1. 构造public
//        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car) c1.newInstance("tank", 10, "红色");
//        System.out.println(car1);
        // 2. 构造private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        Car car2 = (Car) c2.newInstance("bmw", 15, "白色");
        System.out.println(car2);
    }


    // 3. 通过反射获取类中的属性
    @Test
    public void test03() throws Exception{
        Class<Car> clazz = Car.class;
        Car car = (Car)clazz.getDeclaredConstructor().newInstance();
        // 获取所有public属性
        Field[] fields = clazz.getFields();
        // 获取所有属性（包含私有属性）
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f :
                fields1) {
            if (f.getName().equals("name")) {
                f.setAccessible(true);  // 设置允许访问
                f.set(car, "奥迪");
            }
            System.out.println("属性名称："+f.getName());
            System.out.println(car);
        }
    }

    // 4. 通过反射获取方法
    @Test
    public void test04() throws Exception {
        Car car = new Car("奔驰", 10, "black");
        Class clazz = car.getClass();
        // 1. public方法
        Method[] methods = clazz.getMethods();
        for (Method m1 : methods) {
            System.out.println(m1.getName());
            // 执行方法
            if (m1.getName().equals("toString")) {
                String invoke = (String) m1.invoke(car);
                System.out.println("toString方法执行了：" + invoke);
            }
        }
        // 2. private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method m2 : methodsAll) {
            // 执行方法
            if (m2.getName().equals("run")) {
                m2.setAccessible(true);
                m2.invoke(car);
            }

        }


    }


}
