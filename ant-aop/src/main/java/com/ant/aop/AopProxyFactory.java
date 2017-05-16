package com.ant.aop;

/**
 * 获取代理工厂类</div>
 * @author qsfs on 17/5/16.
 */
public class AopProxyFactory {



    public AopProxy getProxyInstance(AdvisedSupport advisedSupport) {
        return new JdkAopProxy(advisedSupport);
    }


}
