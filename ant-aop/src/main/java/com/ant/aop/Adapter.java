package com.ant.aop;

/**
 * 适配器接口</div>
 * <p>主要用于对不同切面进行适配，统一返回方法过滤器</p>
 *
 * @author qsfs on 17/5/16.
 */
public interface Adapter {

    /**
     * 判断此适配器是否支持当前切面
     * @param advice
     * @return
     */
    Boolean Support(Advice advice);


    MethodInterceptor getInterceptor(AntAdvisor antAdvisor);




}
