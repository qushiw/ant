package com.ant.aop;

/**
 * 构造代理类的工厂</div>
 * @author wuguang  on 17/5/16.
 */
public class AntProxyFactoryBean extends AdvisedSupport{

    public AntProxyFactoryBean(Object target) {
        setTarget(target);
    }


    public Object getObject(){
        try {
            initChain();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getAopProxy();
    }

}
