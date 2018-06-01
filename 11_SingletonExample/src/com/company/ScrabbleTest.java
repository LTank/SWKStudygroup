package com.company;
import java.util.LinkedList;

public class ScrabbleTest {

    public static void main(String[] args){

        System.out.println("Singleton eksempel: ");

        System.out.println("========================================");
        // How you create a new instance of Singleton
        Singleton singleton1 = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Vi har nu lavet et singleton1 objekt med id'et: \n" + System.identityHashCode(singleton1));

        System.out.println("========================================");
        System.out.println("Vores singleton1 'spillebræt' har følgende brikker: \n" + singleton1.getLetterList());

        LinkedList<String> playerOneTiles = singleton1.getTiles(2);
        System.out.println("========================================");
        System.out.println("Player 1 har fået følgende brikker: \n" + playerOneTiles);
        System.out.println("========================================");
        System.out.println("Vores scrabble-singleton har følgende brikker tilbage: \n" + singleton1.getLetterList());

        // Hvis vi prøver at lave et nyt singleton objekt med konstruktoren, vil det ikke virke
        // da constructoren er private (ud-kommenteret, da det ikke virker)
        // Singleton instanceTwo = new Singleton();

        // Vi kan dog indhente en instans af vores singleton vha vores egen custom "konstruktor"
        // som vi henter fra statisk kontekst
        Singleton singleton2 = Singleton.getInstance();

        System.out.println("========================================");
        System.out.println("Vi har nu lavet et singleton2 objekt med id'et: \n" + System.identityHashCode(singleton2));

        // This returns the value of the first instance created
        System.out.println("========================================");
        System.out.println("Det viser sig at ID'et er det samme for de to singleton referencer!\n" +
                "Dermed kan vi se at det faktisk er den samme Singleton-instans, de begge referer til:");

        System.out.println("========================================");
        System.out.println("singleton1: " + singleton1.getLetterList());
        System.out.println("singleton2: " + singleton2.getLetterList());


        System.out.println("========================================");
        LinkedList<String> playerTwoTiles = singleton1.getTiles(3);
        System.out.println("Player 2 får nu følgende brikker: " + playerTwoTiles);

    }

}
