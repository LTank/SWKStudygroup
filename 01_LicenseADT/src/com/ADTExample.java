package com;


import static com.VehicleTypes.*;
import static com.MedicalFields.*;

public class ADTExample {
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
        System.out.println(color+"============Kørekorts TEST===============");

        System.out.println(licenseToDrive+"\n");

        System.out.println("Har " + licenseToDrive.ownerOfLicense() + " personbil kørekort?: ");
        System.out.println(licenseToDrive.haveLicenseFor(PERSONBIL)+"\n");

        System.out.println("Giver " + licenseToDrive.ownerOfLicense() + " et kørekort til PERSONBIL!");
        licenseToDrive.grantLicenseFor(PERSONBIL);

        System.out.println("Har " + licenseToDrive.ownerOfLicense() + " personbil kørekort?: ");
        System.out.println(licenseToDrive.haveLicenseFor(PERSONBIL));

        System.out.println(licenseToDrive);

        if(licenseToDrive.isValid()){
            System.out.println("Giver " + licenseToDrive.ownerOfLicense() + " et kørekort til LASTBIL!");
            licenseToDrive.grantLicenseFor(LASTBIL);
            System.out.println(licenseToDrive);
            System.out.println("Fratager " + licenseToDrive.ownerOfLicense() + " hendes kørekort til LASTBIL!");
            licenseToDrive.revokeLicenseFor(LASTBIL);
            System.out.println(licenseToDrive);
            System.out.println("Straffen er hård: det gjorde kortet ugyldigt! \nNu skal have godkendt hendes kort, det får hun nu.");
            licenseToDrive.grantLicenseFor(PERSONBIL);
            System.out.println(licenseToDrive);

        } else {
            System.out.println("\n" + licenseToDrive.ownerOfLicense() + " har ikke et gyldigt kørekort!");
        }
        System.out.println("=========Kørekorts TEST SLUT=============");
    }

    public static void doctorTest(DoctorsLicense doctorsLicense, String color){
        System.out.println(color + "============DOCTOR TEST===============");
        System.out.println("\nKan " + doctorsLicense.ownerOfLicense() + " have egen praksis?: ");
        System.out.println(doctorsLicense.haveLicenseFor(ALMENPRAKSIS));
        System.out.println("Giver " + doctorsLicense.ownerOfLicense() + " en lægelicense til ALMENPRAKSIS:");
        doctorsLicense.grantLicenseFor(ALMENPRAKSIS);
        System.out.println(doctorsLicense);
        if(doctorsLicense.isValid()){

            System.out.println("Giver " + doctorsLicense.ownerOfLicense() + " en lægelicense til HJERTEOPERATION:");
            doctorsLicense.grantLicenseFor(HJERTEOPERATION);
            System.out.println(doctorsLicense);

            System.out.println("Skandale! " + doctorsLicense.ownerOfLicense() + " har stjålet organer!");
            System.out.println("Fratager " + doctorsLicense.ownerOfLicense() + " lægelicensen til HJERTEOPERATIONER");
            doctorsLicense.revokeLicenseFor(HJERTEOPERATION);

            System.out.println(doctorsLicense);

        } else {
            System.out.println("\n" + doctorsLicense.ownerOfLicense() + " er ikke en rigtig læge!");
        }
        System.out.println("=========DOCTOR TEST SLUT=============");
    }
}
