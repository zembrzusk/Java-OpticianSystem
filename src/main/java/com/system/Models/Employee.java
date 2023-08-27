package com.system;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person{
    //attributes with getters and setters
    private String employeeId;
    public String getEmployeeId() {return employeeId;}
    public void setEmployeeId(String employeeId) {this.employeeId = employeeId;}

    int salary;
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        if(salary<0) {
            this.salary = 0;
        }
        this.salary = salary;
    }

    String email;
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    //constructors
    Employee(String employeeId, String name, String surname, String phoneNumber, int salary) {
        super(name, surname, phoneNumber);
        setEmployeeId(employeeId);
        setSalary(salary);
        addEmployee(this);
    }

    Employee(String employeeId, String name, String surname, String phoneNumber, int salary, String email) {
        super(name, surname, phoneNumber);
        setEmployeeId(employeeId);
        setSalary(salary);
        setEmail(email);
        addEmployee(this);
    }


    private static List<Employee> extent = new ArrayList<>();
    public static void addEmployee(Employee employee) {
        extent.add(employee);
    }
    public static void removeEmployee(Employee employee) {
        extent.remove(employee);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Employee.class.getName());
        for (Employee employee : extent) {
            System.out.println(employee);
        }
    }
    public static List<Employee> getExtent() {return extent;}
}

