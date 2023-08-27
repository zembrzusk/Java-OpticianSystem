package com.system;

public abstract class Person {
    //attributes
    String name, surname, phoneNumber;

    //constructors
    Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    Person(String name, String surname, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    //getters and setters
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
