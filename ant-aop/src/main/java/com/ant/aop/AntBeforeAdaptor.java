package com.ant.aop;

/**
 *
 * 前置事件适配器</div>
 * @author wuguang  on 17/5/16.
 */
public class AntBeforeAdaptor implements Adapter {


    @Override
    public Boolean Support(Advice advice) {
        return advice instanceof AntBeforeAdvice;
    }

    @Override
    public MethodInterceptor getInterceptor(AntAdvisor antAdvisor) {
        AntBeforeAdvice antBeforeAdvice = (AntBeforeAdvice)antAdvisor.getAdvice();
        return new BeforeMethodInterceptor(antBeforeAdvice);
    }
}
