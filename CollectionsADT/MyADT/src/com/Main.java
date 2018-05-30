package com;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Person lilleIda = new Person("Ida", 10);
        Person farligeKirsten = new Person("Kirsten", 20);

        Car teslaRoadster = new Car();

        System.out.println(ANSI_GREEN +"Nu går vi alle til køreprøve!");
        lilleIda.grantDriversLicense();
        farligeKirsten.grantDriversLicense();

        System.out.println("\nNu vil alle prøve at køre i bil!");
        teslaRoadster.putInDriversSeat(lilleIda);
        teslaRoadster.drive();

        teslaRoadster.putInDriversSeat(farligeKirsten);
        teslaRoadster.drive();
        farligeKirsten.revokeDriversLicense();
        teslaRoadster.drive();

        System.out.println("\nNu tager kirsten til køreprøve igen!");
        farligeKirsten.grantDriversLicense();
        teslaRoadster.drive();

    }
}
