package com;

import static com.Main.*;

public class DanskBillist extends Billist{
    private boolean haveDriversLicense;

    public DanskBillist(String firstName, String lastName , int age) {
        super(firstName, lastName, age);
    }

    //brugeren af metoden, kender ikke implementeringen.
    //Men kan bare forsøge at give en person et kørekort.
    //Vi har så sat en struktur op for hvor gammel man skal være for det.
    public void grantDriversLicense(){
        if(super.age >= 18){
            System.out.println(ANSI_BLUE + "Tillykke med kørekortet " + firstName + "!");
            haveDriversLicense = true;
        } else {
            System.out.println(ANSI_RED + firstName + " er ikke gammel nok til at få kørekort!");
        }
    }

    public void revokeDriversLicense(){
        if(haveDriversLicense){
            System.out.println(ANSI_CYAN + "Her kommer politiet: Kære " + firstName + ", du kørte for stærkt, vi tager dit kørekort!");
            haveDriversLicense = false;
        }
    }

    public boolean haveDriversLicense() {
        return haveDriversLicense;
    }


    public String nameOnLicense() {
        return "Danskeren, " + firstName.toUpperCase() + " " + lastName.toUpperCase();
    }

}
