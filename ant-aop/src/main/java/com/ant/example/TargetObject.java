package com.ant.example;

/**
 * @author qsfs on 17/5/16.
 */
public class TargetObject implements TargetInterface {

    @Override
    public void doSomeThing() {
        System.out.println("目标方法做点事");
    }
}
