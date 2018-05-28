package com.threads;

import java.sql.Statement;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KontoMedLock extends Konto {
    private static Lock lock = new ReentrantLock();

    @Override
    public void addOneDollar(){
        lock.lock();
        try {
            super.addOneDollar();
        } catch (Exception e){
            System.out.println("Error: " + e.getClass());
        } finally {
            lock.unlock();
        }
    }

}
