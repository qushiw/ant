package com.ant.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * 过滤器链以及目标方法执行</div>
 * @author qsfs on 17/5/16.
 */
public class AntReflectMethodInvocation implements AntMethodInvocation{

    private Object target;

    private Object proxy;

    private Object[] arguments;

    private List<MethodInterceptor> chain;

    private Method method;

    private Integer currentInterceptorIndex = -1;


    public AntReflectMethodInvocation(Object target, Object proxy, Object[] arguments, Method method, List<MethodInterceptor> chain) {
        this.arguments = arguments;
        this.chain = chain;
        this.method = method;
        this.target = target;
        this.proxy = proxy;

    }


    public final Object[] getArguments() {
        return (this.arguments != null ? this.arguments : new Object[0]);
    }



    @Override
    public Method getMethod() {
        return null;
    }

    public Object getTarget() {
        return target;
    }

    @Override
    public Object process() {

        if (currentInterceptorIndex == (chain.size() - 1)) {
            try {
                return method.invoke(target, arguments);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        MethodInterceptor methodInterceptor = (MethodInterceptor)chain.get(++currentInterceptorIndex);
        return methodInterceptor.invoke(this);
    }

}
