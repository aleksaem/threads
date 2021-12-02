package com.machkur.labs.lr1;

public class Main {
    public static void main(String[] args) {
        ThreadGroup myGroup = new ThreadGroup("My Group");
        Thread thread1 = new MyThread(myGroup, "Thread 1");

        MyThreadRun threadRun = new MyThreadRun();

        Thread thread2 = new Thread(myGroup, threadRun);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Name - " + Thread.currentThread().getName()
                        + "; Priority - " + Thread.currentThread().getPriority()
                        + "; Group name - " + Thread.currentThread().getThreadGroup().getName());
            }
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("Name - " + Thread.currentThread().getName()
                    + "; Priority - " + Thread.currentThread().getPriority()
                    + "; Group name - " + Thread.currentThread().getThreadGroup().getName());
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread mainThread = Thread.currentThread();

        System.out.println("Name - " + Thread.currentThread().getName()
                + "; Priority - " + Thread.currentThread().getPriority()
                + "; Group name - " + Thread.currentThread().getThreadGroup().getName());
    }
}
