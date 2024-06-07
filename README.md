# IOC

## 1. 基于XML管理bean

归结起来都是bean.xml文件中如何管理对象，赋值等等，然后在代码中获取bean文件进行后续操作

---
**<font color=orange>获取bean对象的方式</font>**

1. 根据id获取
2. 根据类型获取（要求IOC容器中指定类型的bean有且只能有一个）
3. 根据id和类型获取
4. 如果组件实现了接口，可以根据接口类型获取bean，前提是bean唯一，也就说接口只能由一个实现类，否则若有多个实现了，则bean不唯一，报错
---
**<font color=orange>依赖注入的方式</font>**
1. 使用setter注入，可以在配置文件中为属性赋值，然后在代码中获取配置文件的方式进行注入
2. 采用构造器注入，可以在配置文件中进行属性赋值
3. 特殊值处理：字面量赋值，null值，xml实体，CDATA节
4. 对象类型的属性赋值，对象类型需要通过ref赋值，不能使用value
   1. 引用外部bean
   2. 内部bean，区别于外部bean，只是在配置文件中的写法不一样
   3. 级联赋值
5. 数组类型赋值
6. 集合类型属性赋值：List、Map、引用集合类型
7. 命名空间注入
8. 引入外部文件：配置好依赖，将外部文件准备好，然后在xml配置文件中完成注入
9. bean的作用域：singleton（默认，bean的对象始终为单例），prototype（bean可以有多个实例）
10. bean的生命周期
11. FactoryBean：一种整合第三方框架的常用机制
12. 基于xml的自动装配

---



## 2. 基于注解管理bean

<font color=orange>**使用注解定义bean**</font>

* @Component

* @Repository

* @Service

* @Controller

---

<font color=orange>**@Autowired注入**</font>

* 属性注入
* set注入
* 构造方法上注入
* 形参上注入
* 只有一个构造函数，可以不加注解，自动注入
* @Autowired 和 @Qualifier 联合注解，根据名称注入

---

<font color=orange>**@Resource注入**</font>

1. 根据name进行注入，在注解中直接写清楚要注入的对象
2. 根据类型进行注入
3. 默认byName注入，没有指定name时把属性名当做name，根据name找不到时，才会byType注入。byType注入时，某种类型的Bean只能有一个

---

<font color=orange>**全注解开发**</font>

在基于注解管理bean的基础上，将配置文件写成配置类的形式，完全使用注解进行开发



---

## 3. 手写IOC

<font color=blue>**Java反射机制**</font>

Java的反射机制指的是程序在运行时能够获取自身的信息。

* 1、通过反射获取class对象的方式
* 2、通过反射获取构造方法
  * 获取所有构造
  * 获取public构造
  * 获取private构造
* 3、通过反射获取类中的属性
  * public属性
  * private属性
* 4、通过反射获取方法
  * public方法
  * private方法



<font color=blue>**实现Spring的IOC**</font>















