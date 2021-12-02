package com.machkur.labs.lr1;

public class MyThreadRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Name - " + Thread.currentThread().getName()
                + "; Priority - " + Thread.currentThread().getPriority()
                + "; Group name - " + Thread.currentThread().getThreadGroup().getName());
    }
}
