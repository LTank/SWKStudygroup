package com;

import static com.Main.*;

public class AmerikanskBillist extends Billist{

    private boolean haveAdultDriversLicense;
    private boolean haveYouthDriversLicense;


    public AmerikanskBillist(String firstName, String lastName , int age) {
        super(firstName, lastName, age);
    }

    //brugeren af metoden, kender ikke implementeringen.
    //Men kan bare forsøge at give en person et kørekort.
    //Vi har så sat en struktur op for hvor gammel man skal være for det.
    public void grantDriversLicense(){
        if(age>=21){
            System.out.println(ANSI_BLUE + "Tillykke med dit Amerikanske voksenkørekort " + firstName + ", " + age + "år" +"!");
            haveAdultDriversLicense = true;
        } else if(age >= 16){
            System.out.println(ANSI_BLUE + "Tillykke med dit Amerikanske ungdomskørekort " + firstName + ", " + age + "år" + "!");
            haveYouthDriversLicense = true;
        } else {
            System.out.println(ANSI_PURPLE + firstName + " er ikke gammel nok til at få kørekort her i USA!");
        }
    }

    public void revokeDriversLicense(){

        if(haveYouthDriversLicense || haveAdultDriversLicense){
            System.out.println(ANSI_CYAN + "Her kommer politiet: Kære " + firstName + ", du kørte for stærkt, vi tager dit kørekort!");
            haveAdultDriversLicense = false;
            haveYouthDriversLicense = false;
        }
    }

    public boolean haveDriversLicense() {
        if(age>=21){
            return haveAdultDriversLicense;
        } else {
            return haveYouthDriversLicense;
        }
    }

    public String nameOnLicense() {
        return "Amerikaneren, " + firstName.toUpperCase() + " " + lastName.toUpperCase();
    }



}
