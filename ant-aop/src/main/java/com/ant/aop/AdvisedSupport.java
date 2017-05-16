package com.ant.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * 主要用于对Advised的支持功能</div>
 *
 * @author qsfs on 17/5/16.
 */
public abstract class AdvisedSupport {

    private List<AntAdvisor> antAdvisors = new ArrayList<AntAdvisor>();

    private String[] interceptors;

    private Object target;


    private AopProxyFactory aopProxyFactory;


    public AdvisedSupport () {
        aopProxyFactory = new AopProxyFactory();
    }

    public void addAdvisors(AntAdvisor antAdvisor){
        antAdvisors.add(antAdvisor);
    }

    public void setInterceptors(String[] interceptors) {
        this.interceptors = interceptors;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public AopProxyFactory getAopProxyFactory() {
        return aopProxyFactory;
    }


    public void initChain() throws Exception {
        if (interceptors == null) {
            return;
        }

        for (String interceptor : interceptors) {
            Class  clazz = Class.forName(interceptor);
            Object object = clazz.newInstance();
            if (object instanceof AntAdvisor) {
                antAdvisors.add((AntAdvisor)object);
            }
        }
    }


    public Object getAopProxy(){
        return getProxy(getAopProxyFactory().getProxyInstance(this));
    }


    public Object getProxy(AopProxy aopProxy){
        if (aopProxy instanceof JdkAopProxy) {
            return ((JdkAopProxy) aopProxy).getProxy();
        }
        return null;
    }

    public List<AntAdvisor> getAntAdvisors() {
        return antAdvisors;
    }

    public Object getTarget(){
        return target;
    }


    public List<MethodInterceptor> getInterceptorChain() {
        AntRegistry antRegistry = new AntRegistry();
        List<MethodInterceptor> data = new ArrayList<MethodInterceptor>();
        for (AntAdvisor antAdvisor : antAdvisors) {
            data.addAll(antRegistry.getInterceptors(antAdvisor));
        }
        return data;
    }


    public Class[] getInterfaces() {
        if (target != null){
            return target.getClass().getInterfaces();
        }
        return null;
    }


}
