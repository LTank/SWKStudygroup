package com;

import static com.Main.ANSI_RED;

public abstract class Billist implements DriversLicense {
    protected String firstName;
    protected String lastName;
    protected int age;

    public Billist(String firstName, String lastName , int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void happyBirthDay(){
        age++;
        System.out.println(ANSI_RED + "Tillykke med din " + age + "års fødselsdag " + firstName + "! Hurra Hurra Hurra!");
    }


}
