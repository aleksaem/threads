package com.machkur.labs.lr3;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(500, 500);

        Thread thread1 = new TransferThread(bank);
        Thread thread2 = new TransferThread(bank);

        thread1.start();
        thread2.start();
    }
}
