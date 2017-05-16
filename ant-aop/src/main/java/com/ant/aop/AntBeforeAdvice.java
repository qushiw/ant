package com.ant.aop;

import java.lang.reflect.Method;

/**
 *  业务前置操作，供业务系统继承使用</div>
 *
 * @author qsfs on 17/5/16.
 */
public interface AntBeforeAdvice extends Advice{

    void before(Method method, Object[] args, Object target);

}
