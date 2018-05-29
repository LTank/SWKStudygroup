package com.company;

import java.util.LinkedList;

public class GetTilesTask implements Runnable {

    public void run(){

        // How you create a new instance of Singleton

        Singleton newInstance = Singleton.getInstance();

        // Get unique id for instance object

        System.out.println(Thread.currentThread() + " Instance ID: " + System.identityHashCode(newInstance));

        // Get all of the letters stored in the List


        newInstance.getTiles(3);


        System.out.println(Thread.currentThread() + " Task slut");
    }

}