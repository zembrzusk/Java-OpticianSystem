package com.system.Controllers;

import com.system.Models.Prescription;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DoctorController {
    @FXML
    private Label finalText;
    private TextField id, details, license;
    boolean correctId = false;


    @FXML
    protected void onAddButtonClick() {
        try
        {
            Integer.parseInt(id.getText());
            correctId = true;
        } catch (NumberFormatException ex) {}

        if(correctId) {
            new Prescription(Integer.parseInt(id.getText()), details.getText(), Integer.parseInt(license.getText()));
            finalText.setText("Prescription created.");
        } else {
            finalText.setText("Prescription id must be a number.");
        }
    }
}