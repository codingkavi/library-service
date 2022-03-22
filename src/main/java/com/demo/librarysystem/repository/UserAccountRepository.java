package com.demo.librarysystem.repository;

import javax.persistence.*;

@Entity
public class UserAccountRepository {
    @Id
    @Column(name = "user_Name")
    private String userId;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "password")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "DateofBirth")
    private String birthdate;
    @Column(name = "user_contact")
    private int contact;


    public UserAccountRepository(){

    }
    public UserAccountRepository(String userId,String firstname, String lastname, String password, String email, String address, String birthdate, int contact){

        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.contact = contact;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
    /*public Date getPostedAT() {
        return postedAT;
    }

    public void setPostedAT(Date postedAT) {
        this.postedAT = postedAT;
    }*/
    /*public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }*/




}
