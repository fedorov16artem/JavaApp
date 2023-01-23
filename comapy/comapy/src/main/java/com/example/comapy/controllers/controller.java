package com.example.comapy.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button KeyButtonEnter;

    @FXML
    private Button KeyButtonReg;

    @FXML
    private TextField Login_string;

    @FXML
    private PasswordField Password_string;

    @FXML
    void initialize() {
        KeyButtonReg.setOnAction(this::handle);

    }

    private void handle(ActionEvent actionEvent) {
        KeyButtonReg.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/comapy/SingUP.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
