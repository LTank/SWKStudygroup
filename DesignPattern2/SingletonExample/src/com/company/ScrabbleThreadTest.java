package com.company;

public class ScrabbleThreadTest {

    public static void main(String[] args){

        System.out.println("Singleton Thread Tester!");
        System.out.println("========================");


        // Create a new Thread created using the Runnable interface
        // Execute the code in run after 10 seconds

        Runnable getTiles1 = new GetTilesTask();

        Runnable getTiles2 = new GetTilesTask();

        // Call for the code in the method run to execute

        new Thread(getTiles1).start();
        new Thread(getTiles2).start();

    }

}
