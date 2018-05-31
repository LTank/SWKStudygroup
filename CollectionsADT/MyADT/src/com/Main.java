package com;


import static com.VehicleTypes.*;
import static com.MedicalFields.*;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        Person linda = new Person("Linda", "hansen", 18);
        DriversLicense licenseToDrive = new DriversLicense(linda);
        test(licenseToDrive, ANSI_PURPLE);

        Person lillePer = new Person("Per", "Jensen", 17);
        licenseToDrive = new DriversLicense(lillePer);
        test(licenseToDrive, ANSI_CYAN);

        System.out.println(ANSI_WHITE + "\nLinda Hansen er meget klog og kan godt blive læge\n");

        DoctorsLicense doctorsLicense = new DoctorsLicense(linda.getLastname());
        doctorTest(doctorsLicense, ANSI_GREEN);

    }

    public static void test(DriversLicense licenseToDrive, String color){
        System.out.println(ANSI_BLUE+"============Kørekorts TEST===============");
        System.out.println(color+"har " + licenseToDrive.ownerOfLicense() + " personbil kørekort?: " + licenseToDrive.haveLicenseFor(PERSONBIL));
        System.out.println("Forsøger at give " + licenseToDrive.ownerOfLicense() + " et kørekort.");
        System.out.println(licenseToDrive.grantLicenseFor(PERSONBIL));
        if(licenseToDrive.isValid()){
            System.out.println("\n" + licenseToDrive.ownerOfLicense()+" har et gyldigt kørekort!");
            System.out.println(licenseToDrive.grantLicenseFor(LASTBIL));
            System.out.println("har " + licenseToDrive.ownerOfLicense() + " personbil kørekort?: " + licenseToDrive.haveLicenseFor(PERSONBIL));
            System.out.println("har " + licenseToDrive.ownerOfLicense() + " lastbil kørekort?: " + licenseToDrive.haveLicenseFor(LASTBIL));
            System.out.println(licenseToDrive.revokeLicenseFor(LASTBIL));
            System.out.println("har " + licenseToDrive.ownerOfLicense() + " personbil kørekort?: " + licenseToDrive.haveLicenseFor(PERSONBIL));
        } else {
            System.out.println("\n" + licenseToDrive.ownerOfLicense() + " har ikke et gyldigt kørekort!");
        }
        System.out.println(ANSI_RED + "=========Kørekorts TEST SLUT=============");
    }

    public static void doctorTest(DoctorsLicense doctorsLicense, String color){
        System.out.println(ANSI_BLUE+"============DOCTOR TEST===============");
        System.out.println("kan " + doctorsLicense.ownerOfLicense() + " have egen praksis?: " + doctorsLicense.haveLicenseFor(ALMENPRAKSIS));
        System.out.println("Forsøger at give " + doctorsLicense.ownerOfLicense() + " et en lægelicense.");
        System.out.println(doctorsLicense.grantLicenseFor(ALMENPRAKSIS));
        if(doctorsLicense.isValid()){
            System.out.println("\n" + doctorsLicense.ownerOfLicense()+" har en gyldig lægelicense!");
            System.out.println(doctorsLicense.grantLicenseFor(HJERTEOPERATION));
            System.out.println("kan " + doctorsLicense.ownerOfLicense() + " have egen praksis?: " + doctorsLicense.haveLicenseFor(ALMENPRAKSIS));
            System.out.println("kan " + doctorsLicense.ownerOfLicense() + " foretage hjerteoperationer?: " + doctorsLicense.haveLicenseFor(HJERTEOPERATION));
            System.out.println(doctorsLicense.revokeLicenseFor(HJERTEOPERATION));
            System.out.println("kan " + doctorsLicense.ownerOfLicense() + " foretage hjerteoperationer?: " + doctorsLicense.haveLicenseFor(HJERTEOPERATION));
            System.out.println("kan " + doctorsLicense.ownerOfLicense() + " have egen praksis?: " + doctorsLicense.haveLicenseFor(ALMENPRAKSIS));

        } else {
            System.out.println("\n" + doctorsLicense.ownerOfLicense() + " er ikke en rigtig læge!");
        }
        System.out.println(ANSI_RED + "=========DOCTOR TEST SLUT=============");
    }
}
