package com.system;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Employee{
    String licenceNumber;
    public String getLicenceNumber() {return licenceNumber;}
    public void setLicenceNumber(String licenceNumber) {this.licenceNumber = licenceNumber;}

    public Doctor(String employeeId, String name, String surname, String phoneNumber, int salary, String licenceNumber) {
        super(employeeId, name, surname, phoneNumber, salary);
        setLicenceNumber(licenceNumber);
        addDoctor(this);
    }

    public Doctor(String employeeId, String name, String surname, String phoneNumber, int salary, String email,
                  String licenceNumber) {
        super(employeeId, name, surname, phoneNumber, salary, email);
        setLicenceNumber(licenceNumber);
        addDoctor(this);
    }

    private static List<Doctor> extent = new ArrayList<>();
    public static void addDoctor(Doctor doctor) {
        extent.add(doctor);
    }
    public static void removeDoctor(Doctor doctor) {
        extent.remove(doctor);
        Employee.removeEmployee(doctor);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Doctor.class.getName());
        for (Doctor doctor : extent) {
            System.out.println(doctor);
        }
    }
}
