package com.system.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText, id;

    private Scene scene;
    private Stage stage;
    private Parent root;

    public void switchToHelloView(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDoctorView(ActionEvent event) throws IOException{
        System.out.println(getClass().getResource("doctor-view.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("doctor-view.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSellerView(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("seller-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOpticianView(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("optician-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOwnerView(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("owner-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException{
        switchToDoctorView(event);
        /*char[] arr = String.valueOf(id).toCharArray();
        if(arr[0]=='d') {
            switchToDoctorView(event);
        } else if(arr[0]=='s') {
            switchToSellerView(event);
        } else if(arr[0]=='o') {
            switchToOpticianView(event);
        } else {
            switchToOwnerView(event);
        };*/
    }
}