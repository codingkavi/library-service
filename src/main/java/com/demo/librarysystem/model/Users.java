package com.demo.librarysystem.model;

public class Users {

    String userName;
    String firstName;
    String lastName;
    String password;
    String email;
    int contact;
    String address;
    String birthDate;


    public Users(String userName,String firstname, String lastname, String password, String email, String address, String birthdate, int contact) {

        this.userName = userName;
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthDate = birthdate;
        this.contact = contact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
