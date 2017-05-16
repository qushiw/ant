package com.ant.aop;

/**
 * 后置事件适配器
 * @author qsfs on 17/5/16.
 */
public class AntAfterAdaptor implements Adapter {

    @Override
    public Boolean Support(Advice advice) {
        return advice instanceof AntAfterAdvice;
    }

    @Override
    public MethodInterceptor getInterceptor(AntAdvisor antAdvisor) {
        AntAfterAdvice antAfterAdvice = (AntAfterAdvice)antAdvisor.getAdvice();
        return new AfterMethodInterceptor(antAfterAdvice);
    }

}
