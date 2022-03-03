package com.demo.librarysystem.repository;

import javax.persistence.*;

@Entity
public class UserAccountRepository {
    @Id

    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_contact")
    private int contact;


    public UserAccountRepository(){

    }
    public UserAccountRepository(int uid,String userName,String email,int contact){
        this.userId = uid;
        this.userName = userName;
        this.email = email;
        this.contact = contact;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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



    @Override
    public String toString() {
        return "AccountHolder{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
