package com;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DriversLicense implements License<VehicleTypes> {
    private Person owner;
    private ArrayList<VehicleTypes> types = new ArrayList<>();
    private boolean valid = false;

    public DriversLicense(Person owner) {
        this.owner = owner;
    }


    //brugeren af metoden, kender ikke implementeringen.
    //Men kan bare forsøge at give en person et kørekort.
    //Vi har så sat en struktur op for hvor gammel man skal være for det.
    public String grantLicenseFor(VehicleTypes type){
        if(owner.getAge() >= 18 && !types.contains(type)){
            types.add(type);
            makeValid();
        } else if (owner.getAge() >= 18) {
            makeValid();
        }
        return toString();
    }

    public String revokeLicenseFor(VehicleTypes type){
        if(types.contains(type)){
            types.remove(type);
        }
        makeInvalid();
        return toString();
    }

    public boolean haveLicenseFor(VehicleTypes type) {
        if(types.contains(type)){
            return true;
        } else {
            return false;
        }
    }

    public String ownerOfLicense() {
        return owner.getFullName();
    }

    public boolean isValid(){
        return valid;
    }

    private void makeValid(){
        valid = true;
    }

    private void makeInvalid(){
        valid = false;
    }

    @Override
    public String toString(){
        String delimiter = "==========================";
        String newLine ="\n";
        String cardHolder = "Kørekort for: " + ownerOfLicense() + " " + owner.getAge() + " år.";
        String typevalidity = "Gyldig til følgende køretøjer: " + types.stream().map(String::valueOf).collect(Collectors.joining(" "));
        String validLicense = "Gyldighed: " + valid;
        return             newLine
                + delimiter     + newLine
                + cardHolder    + newLine
                + typevalidity  + newLine
                + validLicense  + newLine
                + delimiter     + newLine;
    }

}
