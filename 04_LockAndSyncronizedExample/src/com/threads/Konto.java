package com.threads;

public abstract class Konto {
    private int amount = 0;

    public void addOneDollar(){
        int newAmount = amount + 1;
        System.out.println(Thread.currentThread() + ": ser denne amount : " + (newAmount - 1));
        System.out.println(Thread.currentThread() + ": sætter den nye amount til : " + newAmount);
        /*Bevidst gør vi problemet værre for at vise problemstillingen*/
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        amount = newAmount;
    }

    public void printAmount(){
        System.out.println(amount);
    }
}
