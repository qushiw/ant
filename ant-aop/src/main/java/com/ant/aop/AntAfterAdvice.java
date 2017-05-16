package com.ant.aop;

import java.lang.reflect.Method;

/**
 * 后置切面,供业务系统继承使用</div>
 * @author qsfs on 17/5/16.
 */
public interface AntAfterAdvice extends Advice{

    /**
     * 切面后置方法
     * @param method
     * @param args
     * @param target
     */
    void after(Method method, Object[] args, Object target);

}
