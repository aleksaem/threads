package com.machkur.labs.lr2;

public class Main {
    public static void main(String[] args) {
       FibonacciNumbers fibonacciNumbers = new FibonacciNumbers(10, "Thread 1", 7);
       EratosthenesSieve eratosthenesSieve = new EratosthenesSieve(10, "Thread 2", 10);

       Thread daemonThread = new Thread(new Runnable() {
           @Override
           public void run() {
               Thread.State state1 = fibonacciNumbers.getThread().getState();
               Thread.State state2 = eratosthenesSieve.getThread().getState();

               System.out.println("State of the " + fibonacciNumbers.getThread().getName() + ": " + state1);
               System.out.println("State of the " + eratosthenesSieve.getThread().getName() + ": " + state2);
           }
       });
       daemonThread.setDaemon(true);
       daemonThread.start();

       Thread mainThread = Thread.currentThread();
       try{
           fibonacciNumbers.getThread().join();
           eratosthenesSieve.getThread().join();

           System.out.println("All threads have already finished!");
           Thread.sleep(5);
       } catch (InterruptedException e){
           e.printStackTrace();
       }

    }
}
