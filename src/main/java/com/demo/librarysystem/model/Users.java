package com.demo.librarysystem.model;

import java.util.Date;

public class Users {
    String userId;
    String firstName;
    String lastName;
    String password;
    String email;
    //set[A-Z].+([1-9]+,.*,.*)
    int contact;
    String address;
    String birthDate;


    public Users(String userId,String firstname, String lastname, String password, String email, String address, String birthdate, int contact) {
        this.userId = userId;
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthDate = birthdate;
        this.contact = contact;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(String birthdate) {
        this.birthDate = birthdate;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
