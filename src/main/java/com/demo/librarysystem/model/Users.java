package com.demo.librarysystem.model;

public class Users {
    int uid;
    String username;
    String useremail;
    //set[A-Z].+([1-9]+,.*,.*)
    int usercontact;


    public Users(int uid,String name, String email, int contact) {
        this.uid = uid;
        this.username = name;
        this.useremail = email;
        this.usercontact = contact;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(int usercontact) {
        this.usercontact = usercontact;
    }

}
