package com.threads;

public class KontoMedSync extends Konto {

    @Override
    public synchronized void addOneDollar(){
        super.addOneDollar();
    }
}
