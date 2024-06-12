package com.kunling.spring6.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面类
@Component  // ioc容器
@Aspect // 表示切面类
public class LogAspect {

    /**
     * 设置切入点和通知类型
     * 通知类型：
     * 前置通知 @Before(value = "切入点表达式配置切入点")
     *    切入点表达式：execution(访问修饰符 增强方法返回的类型 增强方法所在的类全路径.方法名称(方法参数))
     * 返回通知 @AfterReturning
     * 异常通知 @AfterThrowing
     * 后置通知 @After()
     * 环绕通知 @Around()
      */

    // 举例将CalculatorImpl类中的add方法做前置通知
    @Before(value = "execution(public int com.kunling.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名称：" + methodName + "，参数：" + Arrays.toString(args));
    }

    // 后置通知
//    @After(value = "com.kunling.spring6.aop.annoaop.LogAspect.pointCut()")   // 不同切面用类的全路径加方法名
    @After(value = "pointCut()") // 同一个切面直接写重用切入点方法就行
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名称：" + methodName);
    }

    // 返回通知
    @AfterReturning(value = "execution(* com.kunling.spring6.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名称：" + methodName + "，返回结果：" + result);
    }

    // 异常通知，目标方法出现了异常，这个通知才会执行
    @AfterThrowing(value = "execution(* com.kunling.spring6.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名称：" + methodName + "，异常信息：" + ex);
    }

    // 环绕通知
    @Around(value = "execution(* com.kunling.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前执行");
            // 调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常执行");
        } finally {
            System.out.println("环绕通知==目标方法执行完毕");
        }
        return result;
    }

    // 重用切入点表达式
    @Pointcut(value = "execution(* com.kunling.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void pointCut() {

    }


}
