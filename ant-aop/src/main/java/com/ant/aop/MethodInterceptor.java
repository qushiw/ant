package com.ant.aop;

/**
 * 方法过滤器总接口</div>
 * 不同的切面事件对应不同的过滤器接口</p>
 *
 * @author qsfs on 17/5/16.
 */
public interface MethodInterceptor {

    Object invoke(AntReflectMethodInvocation antReflectMethodInvocation);

}
