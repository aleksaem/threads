package com.machkur.labs.lr2;


public class EratosthenesSieve implements Runnable {
    private Thread thread;
    public boolean[] array;

    EratosthenesSieve(int n, String threadName, int threadPriority) {
        thread = new Thread(this, threadName);

        array = new boolean[n + 1];

        if ((threadPriority >= Thread.MIN_PRIORITY) && (threadPriority <= Thread.MAX_PRIORITY))
            thread.setPriority(threadPriority);
        else {
            thread.setPriority(Thread.NORM_PRIORITY);
        }

        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " - begin!");

        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            try {
                Thread.sleep(10);
                if (array[i]) {
                    for (int j = i * i; j <= n; j += i)
                        array[j] = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("First " + (array.length-1) + " prime numbers from Eratosthenes sieve: ");

        for(int i = 2; i < n; i++)
        {
            if(array[i]){
                System.out.print(i + " ");
            }

        }
        System.out.println("");
    }

    public Thread getThread(){
        return thread;
    }
}
