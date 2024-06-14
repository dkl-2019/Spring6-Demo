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





---

# AOP

通常情况下，我们会根据业务使用 OOP（面向对象）思想，将应用划分为多个不同的业务模块，每个模块的核心功能都只为特定的业务领域提供服务，例如电商系统中的订单模块、商品模块、库存模块就分别是为维护电商系统的订单信息、商品信息以及库存信息而服务的。

但除此之外，应用中往往还存在一些非业务的通用功能，例如日志管理、权限管理、事务管理、异常管理等。这些通用功能虽然与应用的业务无关，但几乎所有的业务模块都会使用到它们，因此这些通用功能代码就只能横向散布式地嵌入到多个不同的业务模块之中。这无疑会产生大量重复性代码，不利于各个模块的复用。

您可能会想，可以将这些重复性代码封装成为公共函数，然后在业务模块中显式的调用，不也能减少重复性代码吗？是的，这样做的确能一定程度上减少重复性代码，但这样也增加了业务代码与公共函数的耦合性，任何对于公共函数的修改都会对所有与之相关的业务代码造成影响。

---



## 1. 基于注解的AspectJ AOP开发

* <font color=blue>**5种通知类型**</font>
  * 前置通知：使用@Before注解标识，在被代理的目标方法**前**执行
  * 返回通知：使用@AfterReturning注解标识，在被代理的目标方法**成功结束**后执行（**寿终正寝**）
  * 异常通知：使用@AfterThrowing注解标识，在被代理的目标方法**异常结束**后执行（**死于非命**）
  * 后置通知：使用@After注解标识，在被代理的目标方法**最终结束**后执行（**盖棺定论**）
  * 环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置

* 重用切入点表达式
  * 在同一个切面中直接写方法名即可
  * 在不同的切面中需要写类的全路径加方法名



---

## 2. 基于XML的AspectJ AOP开发

不使用注解的情况下，在xml文件中配置五种通知即可。





## 3. 单元测试

整合 Junit5	Junit4



---

# 事务

## 1. JdbcTemplate

JdbcTemplate 是 Spring JDBC 核心包（core）中的核心类，它可以通过配置文件、注解、Java 配置类等形式获取数据库的相关信息，实现了对 JDBC 开发过程中的驱动加载、连接的开启和关闭、SQL 语句的创建与执行、异常处理、事务处理、数据类型转换等操作的封装。我们只要对其传入SQL 语句和必要的参数即可轻松进行 JDBC 编程。



| 方法                                                         | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| public int update(String sql)                                | 用于执行新增、更新、删除等语句；sql：需要执行的 SQL 语句；args 表示需要传入到 SQL 语句中的参数。 |
| public int update(String sql,Object... args)                 | 同上                                                         |
| public void execute(String sql)                              | 可以执行任意 SQL，一般用于执行 DDL 语句； sql：需要执行的 SQL 语句；action 表示执行完 SQL 语句后，要调用的函数。 |
| public T execute(String sql, PreparedStatementCallback action) | 同上                                                         |
| public <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args) | 用于执行查询语句；sql：需要执行的 SQL 语句；rowMapper：用于确定返回的集合（List）的类型；args：表示需要传入到 SQL 语句的参数。 |
| public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) | 同上                                                         |
| public int[] batchUpdate(String sql, List<Object[]> batchArgs, final int[] argTypes) | 用于批量执行新增、更新、删除等语句； sql：需要执行的 SQL 语句；argTypes：需要注入的 SQL 参数的 JDBC 类型；batchArgs：表示需要传入到 SQL 语句的参数。 |



* <font color=blue>**实现CURD**</font>
  * 1. 装配JdbcTemplate
    2. 测试增删改功能
    3. 查询数据返回对象
    4. 查询数据返回list集合
    5. 查询返回单个的值



## 2. 事务基本概念

<font color=red>事务允许我们将几个或一组操作组合成一个要么全部成功、要么全部失败的工作单元。</font>如果事务中的所有的操作都执行成功，那自然万事大吉。但如果事务中的任何一个操作失败，那么事务中所有的操作都会被<font color=red>回滚</font>，已经执行成功操作也会被完全清除干净，就好像什么事都没有发生一样。



## 3.基于注解的声明式事务



使用步骤：

* 1、开启注解事务

  * tx 命名空间提供了一个 <tx:annotation-driven> 元素，用来开启注解事务，简化 Spring 声明式事务的 XML 配置

* 2、使用@Transactional注解

  * <font color=blue>@Transactional</font>标识在方法上，则只会影响该方法

    <font color=blue>@Transactional</font>标识的类上，则会影响类中所有的方法





事务属性：

* 只读
* 超时
* 回滚策略
* 隔离级别
* 传播行为



全注解配置事务：

* 增加config配置类开启事务管理



---

## 4.基于xml的声明式事务

Spring声明事务管理是通过AOP实现的，其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法后，根据执行情况提交或回滚事务。

通过XML方式实现声明式事务管理，步骤如下：

* 1.引入命名空间
  * 由于Spring提供的声明式事务管理是依赖于Spring AOP实现的，因此我们在XML配置中还应该添加与aop命名空间相关的配置
* 2.配置事务管理器
  * 借助数据源配置DataSourceTransactionManager，定义相关的事务管理器实现的Bean 
* 3.配置事务通知
  * 指定事务作用的方法以及所需的事务属性
  * 事务管理器配置：使用 <tx:advice> 来声明事务时，需要通过 transaction-manager 参数来定义一个事务管理器，这个参数的取值默认为 transactionManager
  * 事务属性配置：对于<tx:advice> 来说，事务属性是被定义在<tx:attributes> 中的，该元素可以包含一个或多个 <tx:method> 元素
* 配置切面点
  * 元素只是定义了一个AOP通知，它并不是一个完整的事务性切面。我们在 <tx:advice> 元素中并没有定义哪些 Bean 应该被通知，因此我们需要一个切点来做这件事









