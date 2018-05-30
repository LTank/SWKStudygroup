package com;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        //I Danmark:

        Billist lilleIda = new DanskBillist("Ida", "Hansen" ,17);
        Billist hurtigeKirsten = new DanskBillist("Kirsten","Larsson", 49);

        Car car = new Car();
        System.out.println(ANSI_GREEN+"===============================================");
        System.out.println(ANSI_GREEN+"==I Danmark går Ida og Kirsten til køreprøve!==");
        System.out.println(ANSI_GREEN+"===============================================");
        lilleIda.grantDriversLicense();
        hurtigeKirsten.grantDriversLicense();


        System.out.println(ANSI_GREEN +"\n==Nu vil de begge prøve at køre i bil!==");
        car.putInDriversSeat(lilleIda);
        car.drive();
        System.out.println(ANSI_GREEN+"==");
        car.putInDriversSeat(hurtigeKirsten);
        car.drive();

        System.out.println(ANSI_GREEN + "\n==Kirsten er lidt af en fartbølle!==");
        hurtigeKirsten.revokeDriversLicense();
        car.drive();

        System.out.println(ANSI_GREEN + "\n==Nu tager kirsten til køreprøve igen!==");
        hurtigeKirsten.grantDriversLicense();
        car.drive();

        System.out.println(ANSI_GREEN + "\n==Nu er der gået et år og Ida går til køreprøve igen!==");
        lilleIda.happyBirthDay();
        lilleIda.grantDriversLicense();

        car.putInDriversSeat(lilleIda);
        car.drive();



        //I USA:

        System.out.println(ANSI_GREEN +   "\n\n=======================================================================");
        System.out.println(ANSI_GREEN +   "==I USA kan man også have kørekort, men af to typer, baseret på alder==");
        System.out.println(ANSI_GREEN +   "=======================================================================");

        Billist roger = new AmerikanskBillist("Roger", "Moore", 49);
        Billist littleJimmy = new AmerikanskBillist("Jimmy", "Johnson", 20);

        roger.grantDriversLicense();
        car.putInDriversSeat(roger);
        car.drive();

        System.out.println(ANSI_GREEN+"==");

        //få ungdomskørekort
        littleJimmy.grantDriversLicense();
        car.putInDriversSeat(littleJimmy);
        car.drive();

        //Jimmy er blevet voksen
        System.out.println(ANSI_GREEN + "\n==Nu er der gået et år og Jimmy skal til en ny køreprøve for at kunne køre!==");
        littleJimmy.happyBirthDay();
        car.putInDriversSeat(littleJimmy);
        car.drive();

        System.out.println(ANSI_GREEN+"==");

        //få voksenkørekort
        littleJimmy.grantDriversLicense();
        car.drive();

    }
}
