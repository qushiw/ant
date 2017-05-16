package com.ant.aop;

/**
 *
 * @author qsfs on 17/5/16.
 */
public class DefaultAntAdvisor {
    private PointCut pointCut;

    private Advice advice;


    public DefaultAntAdvisor(Advice advice){
        this(null, advice);
    }

    public DefaultAntAdvisor(PointCut pointCut, Advice advice) {
        this.advice = advice;
        this.pointCut = pointCut;
    }
}
