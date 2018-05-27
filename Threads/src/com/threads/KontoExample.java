package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KontoExample {

    ExecutorService executorService;


    static Konto konto;

    public void runExample(){

        System.out.println();
        System.out.println("Vi tilføjer 10 kr til den usynkroniserede konto, vha af 10 threads");
        System.out.println();

        konto = new KontoUdenSync();
        addWithTwentyThreads();
        System.out.println();
        System.out.println("Her er penge balancen på den usynkroniserede konto: ");
        konto.printAmount();
        System.out.println();

        System.out.println();
        System.out.println("Vi tilføjer 10 kr til den synkroniserede konto, vha af 10 threads");
        System.out.println();

        /*Igen, nu med syncronized keyword*/

        konto = new KontoMedSync();
        addWithTwentyThreads();
        System.out.println();
        System.out.println("Her er penge balancen på den synkroniserede konto: ");
        konto.printAmount();
        System.out.println();

        /*Igen, igen nu med en Lock*/

        konto = new KontoMedLock();
        addWithTwentyThreads();
        System.out.println();
        System.out.println("Her er penge balancen på den konto med en LÅS: ");
        konto.printAmount();
        System.out.println();

    }

    private void addWithTwentyThreads(){
        executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++){
            executorService.execute(new AddMoneyTask(konto));
        }
        executorService.shutdown();

        while (!executorService.isTerminated()){
            //vi venter
        }
    }






}
