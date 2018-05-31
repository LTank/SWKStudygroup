package com;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DoctorsLicense implements License<FieldsOfDoctorKnowledge> {
    private ArrayList<FieldsOfDoctorKnowledge> fieldsOfKnowledge = new ArrayList<>();
    private String lastName;

    public DoctorsLicense(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String grantLicenseFor(FieldsOfDoctorKnowledge field) {
        if(!fieldsOfKnowledge.contains(field)){
            fieldsOfKnowledge.add(field);
        }
        return toString();
    }

    @Override
    public String revokeLicenseFor(FieldsOfDoctorKnowledge field) {
        if(fieldsOfKnowledge.contains(field)){
            fieldsOfKnowledge.remove(field);
        }
        return toString();
    }

    @Override
    public boolean haveLicenseFor(FieldsOfDoctorKnowledge field) {
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

    @Override
    public String toString(){

        return ownerOfLicense() + " : " + fieldsOfKnowledge.stream().map(Enum::toString).collect(Collectors.joining(" ")) + " : " + isValid();
    }
}
