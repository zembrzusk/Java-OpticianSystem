package com.system.Models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    //attributes
    private int customerId;
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {
        if (customerId == 0) {throw new IllegalArgumentException("Customer id can not be 0.");}
        this.customerId = customerId;
    }

    private int nip;
    public int getNip() {return nip;}
    public void setNip(int nip) {
        if ((nip+"").length() != 10) {
            throw new IllegalArgumentException("Nip should be 10 digits.");
        } else{
            this.nip = nip;
        }
    }

    private String address;
    public String getAddress() {return address;}
    public void setAddress(String address) {
        if(address==null) {
            this.address = null;
        } else {
            this.address = address;
        }
    }

    //constructors
    public Customer(int customerId, String name, String surname, int phoneNumber) {
        super(name, surname, phoneNumber);
        setCustomerId(customerId);
    }

    public Customer(int customerId, String name, String surname, int phoneNumber, int nip, String address) {
        super(name, surname, phoneNumber);
        setCustomerId(customerId);
        setNip(nip);
        setAddress(address);
    }


    private List<Order> orders = new ArrayList<>();
    public void addOrder(Order order) throws Exception {
        if(!orders.contains(order)) {
            orders.add(order);
        }
    }
}
