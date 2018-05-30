package com;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Person lilleIda = new Person("Ida", 17);
        Person farligeKirsten = new Person("Kirsten", 49);

        Car teslaRoadster = new Car();

        System.out.println(ANSI_GREEN +"==Nu går vi alle til køreprøve!==");
        lilleIda.grantDriversLicense();
        farligeKirsten.grantDriversLicense();

        System.out.println(ANSI_GREEN +"\n==Nu vil alle prøve at køre i bil!==");
        teslaRoadster.putInDriversSeat(lilleIda);
        teslaRoadster.drive();

        teslaRoadster.putInDriversSeat(farligeKirsten);
        teslaRoadster.drive();

        System.out.println(ANSI_GREEN + "\n==Kirsten er lidt af en fartbølle!==");
        farligeKirsten.revokeDriversLicense();
        teslaRoadster.drive();

        System.out.println(ANSI_GREEN + "\n==Nu tager kirsten til køreprøve igen!==");
        farligeKirsten.grantDriversLicense();
        teslaRoadster.drive();

        System.out.println(ANSI_GREEN + "\n==Nu er der gået et år og Ida går til køreprøve igen!==");
        lilleIda.happyBirthDay();
        lilleIda.grantDriversLicense();

        teslaRoadster.putInDriversSeat(lilleIda);
        teslaRoadster.drive();






    }
}
