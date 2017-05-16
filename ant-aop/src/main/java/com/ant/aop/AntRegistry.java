package com.ant.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器注册器,以及获取拦截器链</div>
 *
 * @author  on 17/5/16.
 */
public class AntRegistry {

    List<Adapter> adapters = new ArrayList<Adapter>();

    public AntRegistry(){
        registry(new AntBeforeAdaptor());
        registry(new AntAfterAdaptor());
    }



    private void registry(Adapter adapter){
        adapters.add(adapter);
    }


    public List<MethodInterceptor> getInterceptors(AntAdvisor antAdvisor) {

        List<MethodInterceptor> methodInterceptors = new ArrayList<MethodInterceptor>();
        Advice advice = antAdvisor.getAdvice();

        for (Adapter adapter : adapters) {
            if (adapter.Support(advice)) {
                methodInterceptors.add(adapter.getInterceptor(antAdvisor));
            }
        }

        return methodInterceptors;

    }
}
