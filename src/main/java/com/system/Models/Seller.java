package com.system;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Employee{

    Seller(String employeeId, String name, String surname, String phoneNumber, int salary) {
        super(employeeId, name, surname, phoneNumber, salary);
        addSeller(this);
    }

    public Seller(String employeeId, String name, String surname, String phoneNumber, int salary, String email) {
        super(employeeId, name, surname, phoneNumber, salary, email);
        addSeller(this);
    }

    private static List<Seller> extent = new ArrayList<>();
    public static void addSeller(Seller seller) {
        extent.add(seller);
    }
    public static void removeSeller(Seller seller) {
        extent.remove(seller);
        Employee.removeEmployee(seller);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Seller.class.getName());
        for (Seller seller : extent) {
            System.out.println(seller);
        }
    }
}
