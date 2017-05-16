package com.ant.aop;

import java.lang.reflect.Method;

/**
 * 目标方法调用,代理类执行的时候使用此类执行过滤器方法以及目标方法</div>
 *
 * @author qsfs on 17/5/16.
 */
public interface AntMethodInvocation {

    /**
     * 获取目标方法</div>
     * @return
     */
    Method getMethod();

    /**
     * 执行过滤方法</div>
     * @return
     */
    Object process();

}
