package com;

public class Person {
    private String firstname;
    private String lastname;
    private int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getFullName(){
        return firstname + " " + lastname;
    }

    public String getLastname() {
        return lastname;
    }
}
