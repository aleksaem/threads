package com.machkur.labs.lr1;

public class MyThread extends Thread{
    MyThread(ThreadGroup threadGroup, String name){
        super(threadGroup, name);
    }

    @Override
    public void run() {
        System.out.println("Name - " + Thread.currentThread().getName()
                + "; Priority - " + Thread.currentThread().getPriority()
                + "; Group name - " + Thread.currentThread().getThreadGroup().getName());
    }
}
