package com.system;

public class Owner extends Person{
    //attributes
    int ownerId;
    public int getOwnerId() {return ownerId;}
    public void setOwnerId(int ownerId) {this.ownerId = ownerId;}

    //constructors
    Owner(int ownerId, String name, String surname) {
        super(name, surname);
        setOwnerId(ownerId);
    }

    Owner(int ownerId, String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        setOwnerId(ownerId);
    }
}
