package com.system;

import com.system.Models.Doctor;
import com.system.Models.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrescriptionsController {

    @FXML
    TextField doctorId;
    @FXML
    Label nameLabel;
    @FXML
    ListView<Prescription> list = new ListView<Prescription>();
    public void onSearchDoctorButtonClick() {
        Doctor doctor = Doctor.getDoctorExtent().stream()
                .filter(doc -> doc.getEmployeeId().equals(doctorId.getText()))
                .collect(Collectors.toCollection(ArrayList::new)).get(0);

        nameLabel.setText(doctor.getSurname() + " " + doctor.getName() + "\n" +
                "License number: " + doctor.getLicenceNumber());


        List<Prescription> prescriptions = Prescription.getExtent().stream()
                .filter(prescription -> prescription.getLicenseNumber()==doctor.getLicenceNumber())
                .collect(Collectors.toCollection(ArrayList::new));

        //set list
        list.setItems(FXCollections.observableArrayList(prescriptions));
    }

    private void updateList() {

    }

    @FXML
    private Scene scene;
    private Stage stage;
    private Parent root;
    public void onLogoutButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    public void onMarkDoneButtonClick() {
        Prescription prescription = list.getSelectionModel().getSelectedItem();
        prescription.setCompleted(true);
        onSearchDoctorButtonClick();
    }
}
