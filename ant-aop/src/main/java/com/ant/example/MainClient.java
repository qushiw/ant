package com.ant.example;

import com.ant.aop.AntProxyFactoryBean;
import com.ant.aop.DefaultPointcutAdvisor;

/**
 * @author qsfs on 17/5/16.
 */
public class MainClient {

    public static void main(String[] args) {
        TargetInterface target = new TargetObject();
        AntProxyFactoryBean antProxyFactoryBean = new AntProxyFactoryBean(target);
        antProxyFactoryBean.addAdvisors(new DefaultPointcutAdvisor(new BeforeAdvice()));
        antProxyFactoryBean.addAdvisors(new DefaultPointcutAdvisor(new AfterAdvice()));
        TargetInterface proxy = (TargetInterface)antProxyFactoryBean.getObject();
        proxy.doSomeThing();
    }
}
