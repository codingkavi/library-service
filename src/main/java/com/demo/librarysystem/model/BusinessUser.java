package com.demo.librarysystem.model;

public class BusinessUser extends User {
    long annualFee;
    private String typeOfUser;

    public BusinessUser(int id, String name, String email, int contact) {
        super(id, name, email, contact);
    }
}
