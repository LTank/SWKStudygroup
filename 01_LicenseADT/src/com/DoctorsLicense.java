package com;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DoctorsLicense implements License<MedicalFields> {
    private ArrayList<MedicalFields> fieldsOfKnowledge = new ArrayList<>();
    private String lastName;

    public DoctorsLicense(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String grantLicenseFor(MedicalFields field) {
        if(!fieldsOfKnowledge.contains(field)){
            fieldsOfKnowledge.add(field);
        }
        return toString();
    }

    @Override
    public String revokeLicenseFor(MedicalFields field) {
        if(fieldsOfKnowledge.contains(field)){
            fieldsOfKnowledge.remove(field);
        }
        return toString();
    }

    @Override
    public boolean haveLicenseFor(MedicalFields field) {
        if(fieldsOfKnowledge.contains(field)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isValid() {
        if(fieldsOfKnowledge.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String ownerOfLicense() {
        return "Dr. " + lastName;
    }

    public String toString(){
        String delimiter = "==========================";
        String newLine ="\n";
        String owner = "LægeLicense for: " + ownerOfLicense();
        String typevalidity = "Gyldig til følgende faglige områder: " + fieldsOfKnowledge.stream().map(String::valueOf).collect(Collectors.joining(" "));
        String validLicense = "Gyldighed: " + isValid();
        return                    newLine
                + delimiter     + newLine
                + owner         + newLine
                + typevalidity  + newLine
                + validLicense  + newLine
                + delimiter     + newLine;
    }
}
