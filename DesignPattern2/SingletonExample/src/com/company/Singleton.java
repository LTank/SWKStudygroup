package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {

    private static Singleton firstInstance = null;

    private String[] scrabbleLetters = {"a","b","c","d","e","f"};

    private LinkedList<String> letterList = new LinkedList<String> (Arrays.asList(scrabbleLetters));

    // Used to slow down 1st thread
    static boolean firstThread = true;

    // Created to keep users from instantiation
    // Only Singleton will be able to instantiate this class

    private Singleton() { }

    // We could make getInstance a synchronized method to force
    // every thread to wait its turn. That way only one thread
    // can access a method at a time.

    //syncronized for at threads ikke kan komme til at overskrive den allerede instansierede reference
    public static synchronized Singleton getInstance() {
        if(firstInstance == null) {

            // This is here to test what happens if threads try
            // to create instances of this class
            if(firstThread == true){

                firstThread = false;

                try {
                    System.out.println("Tråd " + Thread.currentThread() +" sover nu");
                    Thread.sleep(1000);
                    System.out.println("Tråd " + Thread.currentThread() +" vågner nu");
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }

            // If the instance isn't needed it isn't created
            // This is known as lazy instantiation
            System.out.println("Laver et nyt singleton objekt!");
            firstInstance = new Singleton();

        }

        // Under either circumstance this returns the instance

        return firstInstance;
    }

    public LinkedList<String> getLetterList(){

        return firstInstance.letterList;

    }

    //getTiles er også syncronized for at gøre printlines mere pædagogiske, men kan sagtens fjernes, så ser eksemplet også bedre ud ifht threads.
    public synchronized LinkedList<String> getTiles(int howManyTiles){

        // Tiles to be returned to the user

        LinkedList<String> tilesToSend = new LinkedList<String>();


            System.out.println(Thread.currentThread() + " ser følgende bogstaver " + getLetterList());
            // Cycle through the LinkedList while adding the starting
            // Strings to the to be returned LinkedList while deleting
            // them from letterList

            for(int i = 0; i < howManyTiles; i++){

                tilesToSend.add(firstInstance.letterList.remove(0));

            }

            System.out.println(Thread.currentThread() + " en spiller får følgende bogstaver " + tilesToSend);
            System.out.println(Thread.currentThread() + " har efterladt følgende bogstaver " + getLetterList());

        // Return the number of letter tiles requested


        return tilesToSend;

    }

}