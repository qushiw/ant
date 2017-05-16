package com.ant.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 代理对象类</div>
 * @author qsfs on 17/5/16.
 */
public class JdkAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advisedSupport;


    public JdkAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }



    public Object getProxy() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return Proxy.newProxyInstance(classLoader, advisedSupport.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        List<AntAdvisor> antAdvisorList = advisedSupport.getAntAdvisors();
        if (antAdvisorList.isEmpty()) {
            return method.invoke(args, proxy);
        }
        List<MethodInterceptor> chain = advisedSupport.getInterceptorChain();
        AntMethodInvocation antMethodInvocation = new AntReflectMethodInvocation(advisedSupport.getTarget(), proxy, args, method, chain);
        return antMethodInvocation.process();
    }
}
