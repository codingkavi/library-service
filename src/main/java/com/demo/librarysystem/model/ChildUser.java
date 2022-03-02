package com.demo.librarysystem.model;

public class ChildUser extends User {

    private String school;
    private String typeOfUser;


    public ChildUser(int id, String name, String email, int contact) {
        super(id, name, email, contact);
    }
}
