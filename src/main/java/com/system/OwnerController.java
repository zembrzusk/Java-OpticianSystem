package com.system.Controllers;

import com.system.Models.Doctor;
import com.system.Models.Employee;
import com.system.Models.Optician;
import com.system.Models.Seller;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OwnerController {
    @FXML
    private Label finalText;
    private ChoiceBox type;
    private TextField id, name, surname, phone, salary, mail, license;
    boolean correctId = false, correctSal = false, correctPhone = false;

    @FXML
    protected void onAddButtonClick() {
        try
        {
            Integer.parseInt(String.valueOf(id));
            correctId = true;
        } catch (NumberFormatException ex) {correctId = false;}

        try
        {
            Integer.parseInt(String.valueOf(salary));
            correctSal = true;
        } catch (NumberFormatException ex) {correctSal = false;}

        try
        {
            Integer.parseInt(String.valueOf(phone));
            correctPhone = true;
            if(String.valueOf(phone).length()==9)
                correctPhone = true;
            correctPhone = false;
        } catch (NumberFormatException ex) {correctPhone = false;}

        if(correctId && correctSal && correctPhone) {
            if(type.getValue()=="Seller"){
                new Seller(id.getText(), name.getText(), surname.getText(), Integer.parseInt(phone.getText()),
                        Integer.parseInt(salary.getText()), mail.getText());
            } else if(type.getValue()=="Doctor") {
                new Doctor(id.getText(), name.getText(), surname.getText(), Integer.parseInt(phone.getText()),
                        Integer.parseInt(salary.getText()), mail.getText(), Integer.parseInt(license.getText()));
            } else if(type.getValue()=="Optician") {
                new Optician(id.getText(), name.getText(), surname.getText(), Integer.parseInt(phone.getText()),
                        Integer.parseInt(salary.getText()), mail.getText());
            }
            finalText.setText("Prescription created.");
        } else {
            finalText.setText("Prescription id must be a number.");
        }

    }

    @FXML
    private TextField id2, salary2;
    boolean correctSal2 = false;

    @FXML
    protected void on2AddButtonClick() {
        try
        {
            Integer.parseInt(String.valueOf(salary));
            correctSal2 = true;
        } catch (NumberFormatException ex) {correctSal2 = false;}

        if(correctSal2) {
            List<Employee> emp = Employee.getExtent().stream()
                    .filter(employee -> employee.getEmployeeId().equals(String.valueOf(id)))
                    .collect(Collectors.toCollection(ArrayList::new));

            if (emp.toArray().length==1) {
                Employee employee = emp.get(0);
                employee.setSalary( Integer.parseInt(String.valueOf(salary)));
                char[] arr = String.valueOf(id2).toCharArray();
                if(arr[0]=='d') {
                    Doctor.removeDoctor((Doctor) employee);
                    Doctor.addDoctor(new Doctor(employee.getEmployeeId(), employee.getName(), employee.getSurname(), employee.getPhoneNumber(),
                            employee.getSalary(), employee.getEmail(), ((Doctor) employee).getLicenceNumber()));
                } else if(arr[0]=='s') {
                    Seller.removeSeller((Seller) employee);
                    Seller.addSeller(new Seller(employee.getEmployeeId(), employee.getName(), employee.getSurname(), employee.getPhoneNumber(),
                            employee.getSalary(), employee.getEmail()));
                } if(arr[0]=='o') {
                    Optician.removeOptician((Optician) employee);
                    Optician.addOptician(new Optician(employee.getEmployeeId(), employee.getName(), employee.getSurname(), employee.getPhoneNumber(),
                            employee.getSalary(), employee.getEmail()));
                };


                finalText.setText("Salary changed");
            } else {
                finalText.setText("Error");
            }
        }
    }
}

