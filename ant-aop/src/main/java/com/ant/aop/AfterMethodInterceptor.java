package com.ant.aop;

/**
 * 后置方法过滤器</div>
 * 将后置advice进行封装</p>
 * @author qsfs on 17/5/16.
 */
public class AfterMethodInterceptor implements MethodInterceptor{

    private AntAfterAdvice antAfterAdvice;

    public AfterMethodInterceptor(AntAfterAdvice antAfterAdvice) {
        this.antAfterAdvice = antAfterAdvice;
    }



    @Override
    public Object invoke(AntReflectMethodInvocation antReflectMethodInvocation) {
        Object object = antReflectMethodInvocation.process();
        antAfterAdvice.after(antReflectMethodInvocation.getMethod(), antReflectMethodInvocation.getArguments(),antReflectMethodInvocation.getTarget());
        return object;
    }
}
