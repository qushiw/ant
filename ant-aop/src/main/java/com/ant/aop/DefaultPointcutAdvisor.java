package com.ant.aop;

/**
 * @author qsfs on 17/5/16.
 */
public class DefaultPointcutAdvisor implements AntAdvisor{

    private Advice advice;


    public DefaultPointcutAdvisor(Advice advice){
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }


}
