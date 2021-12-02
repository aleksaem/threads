package com.machkur.labs.lr2;

import java.util.Arrays;

public class FibonacciNumbers implements Runnable{
    private Thread thread;
    public int[] array;

    FibonacciNumbers(int n, String threadName, int threadPriority){
        thread = new Thread(this, threadName);

        array = new int[n];

        if ((threadPriority>=Thread.MIN_PRIORITY)&&(threadPriority<=Thread.MAX_PRIORITY))
            thread.setPriority(threadPriority);
        else {
            thread.setPriority(Thread.NORM_PRIORITY);
        }

        thread.start();
    }

    @Override
    public void run(){
        System.out.println(thread.getName() + " - begin!");

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            try {
                Thread.sleep(10);
                array[i] = array[i - 1] + array[i - 2];
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("First " + array.length + " Fibonacci numbers: " + Arrays.toString(array));
    }

    public Thread getThread(){
        return thread;
    }
}
