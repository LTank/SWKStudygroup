package com;

import static com.Main.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Car {


    private Person driver;

    public void putInDriversSeat(Person driver){
        System.out.println(ANSI_WHITE + driver.getName() + " sætter sig i bilen.");
        this.driver = driver;
    }

    public void drive(){
        if(driver.haveDriversLicense()){
            System.out.println( ANSI_BLUE + "Bilen starter! " + driver.getName() + " kører afsted!");
        } else {
            System.out.println(ANSI_RED + driver.getName() + " prøver at starte bilen, men må ikke køre bil!");
        }
    }




}
