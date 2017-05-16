package com.ant.example;


import com.ant.aop.AntBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author qsfs  on 17/5/16.
 */
public class BeforeAdvice implements AntBeforeAdvice{


    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("目标方法前置事件");
    }
}
