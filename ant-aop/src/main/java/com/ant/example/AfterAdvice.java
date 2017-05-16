package com.ant.example;

import com.ant.aop.AntAfterAdvice;

import java.lang.reflect.Method;

/**
 * @author qsfs on 17/5/16.
 */
public class AfterAdvice implements AntAfterAdvice{

    @Override
    public void after(Method method, Object[] args, Object target) {
        System.out.println("目标方法后置事件");
    }
}
