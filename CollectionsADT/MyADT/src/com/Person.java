package com;

import static com.Main.*;

public class Person {
    private String name;
    private int age;
    private boolean haveDriversLicense;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void grantDriversLicense(){
        if(age >= 18){
            System.out.println(ANSI_BLUE + "Tillykke med kørekortet " + name + "!");
            haveDriversLicense = true;
        } else {
            System.out.println(ANSI_PURPLE + name + " er ikke gammel nok til at få kørekort!");
        }
    }

    public void revokeDriversLicense(){
        if(haveDriversLicense){
            System.out.println(ANSI_CYAN + "Her kommer politiet: Kære " + name + ", du kørte for stærkt, vi tager dit kørekort!");
            haveDriversLicense = false;
        }
    }

    public boolean haveDriversLicense() {
        return haveDriversLicense;
    }

    public String getName(){
        return name;
    }
}
