package com;

public interface License<T> {

    String grantLicenseFor(T t);

    String revokeLicenseFor(T t);

    boolean haveLicenseFor(T t);

    boolean isValid();

    String ownerOfLicense();


}
