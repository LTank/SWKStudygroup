package com;

import static com.Main.*;

public class Car {

    private DriversLicense driversLicense;

    public void putInDriversSeat(Billist driver){
        System.out.println(ANSI_WHITE + driver.nameOnLicense() + " sætter sig i bilen.");
        this.driversLicense = driver;
    }

    public void drive(){
        if(driversLicense.haveDriversLicense()){
            System.out.println( ANSI_BLUE + driversLicense.nameOnLicense() + " kører afsted!");
        } else {
            System.out.println(ANSI_RED + driversLicense.nameOnLicense() + " prøver at starte bilen, men må ikke køre bil!");
        }
    }




}
