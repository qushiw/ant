package com.ant.aop;

/**
 * 前置方法拦截器实现类</div>
 * @author qsfs on 17/5/16.
 */
public class BeforeMethodInterceptor implements MethodInterceptor{

    private AntBeforeAdvice antBeforeAdvice;

    BeforeMethodInterceptor(AntBeforeAdvice antBeforeAdvice){
        this.antBeforeAdvice = antBeforeAdvice;
    }

    @Override
    public Object invoke(AntReflectMethodInvocation antReflectMethodInvocation) {

        antBeforeAdvice.before(antReflectMethodInvocation.getMethod(), antReflectMethodInvocation.getArguments(), antReflectMethodInvocation.getTarget());
        return antReflectMethodInvocation.process();
    }
}
