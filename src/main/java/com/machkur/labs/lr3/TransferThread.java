package com.machkur.labs.lr3;

public class TransferThread extends Thread{

    private Bank bank;

    public TransferThread(Bank bank){
        this.bank = bank;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            try{
                bank.transfer();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
