package com.example.JPAdemo.Model;

//@Entity
public class CardHolderDetails {
    //@Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null) {
        this.firstName = " ";
        }else
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
