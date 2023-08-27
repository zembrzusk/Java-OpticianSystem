package com.system;

import java.util.ArrayList;
import java.util.List;

public class Optician extends Employee{

    Optician(String employeeId, String name, String surname, String phoneNumber, int salary) {
        super(employeeId, name, surname, phoneNumber, salary);
        addOptician(this);
    }

    public Optician(String employeeId, String name, String surname, String phoneNumber, int salary, String email) {
        super(employeeId, name, surname, phoneNumber, salary, email);
        addOptician(this);
    }

    private static List<Optician> extent = new ArrayList<>();
    public static void addOptician(Optician optician) {
        extent.add(optician);
    }
    public static void removeOptician(Optician optician) {
        extent.remove(optician);
        Employee.removeEmployee(optician);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Optician.class.getName());
        for (Optician optician : extent) {
            System.out.println(optician);
        }
    }
}
