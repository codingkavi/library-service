package com.demo.librarysystem.repository;

import com.demo.librarysystem.model.Book;
import com.demo.librarysystem.model.User;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class UserAccountRepository {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_contact")
    private int contact;


    public UserAccountRepository(){

    }
    public UserAccountRepository(int userId, String userName,String email,int contact){
        this.userId = userId;
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
