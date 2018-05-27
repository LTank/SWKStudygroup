package com.threads;

public class AddMoneyTask implements Runnable{

    Konto konto;

    public AddMoneyTask(Konto konto) {
        this.konto = konto;
    }

    @Override
    public void run() {

        konto.addOneDollar();

    }
}
