package com.example.comapy.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.comapy.models.DepatmentsModel;
import com.example.comapy.services.DataBaseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.comapy.services.ButtonSevices;


public class SingUP implements Initializable {


    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button ADDepatment;
    @FXML
    private Button ButtonDepatment;
    @FXML
    private Button ButtonRedDepatment;
    @FXML
    private Button DBDepatment;
    @FXML
    private TextField delDepatment;
    @FXML
    private TextField RedDownDepatment;
    @FXML
    private TextField RedUPDepatment11;
    @FXML
    private TextField nameTitleDepatment;
    @FXML
    private Button unAddDepatment;
    @FXML
    private TableColumn<DepatmentsModel, String> NameTable_Depatments1;
    @FXML
    private TableColumn<DepatmentsModel, Integer> NumTable_Depatments1;
    @FXML
    private TableView<DepatmentsModel> Table_Depatments1;
    @FXML
    private TableColumn<DepatmentsModel, Integer> idTable_Depatments1;
    @FXML
    void ButtonDep(ActionEvent event) throws IOException {
        ButtonSevices buttonSevices = new ButtonSevices();
        buttonSevices.ButtonSwitch("/com/example/comapy/Employee.fxml", event, "Сотрудники");
    }
    @FXML
    void DBD(ActionEvent event) throws IOException {
        ButtonSevices buttonSevices = new ButtonSevices();
        buttonSevices.ButtonSwitch("/com/example/comapy/hello-view.fxml", event, "Сотрудники");
    }
    @FXML
    void BRedDepatment(ActionEvent event) {
        updateCategory();
    }
    @FXML
    void addDep(ActionEvent event) {
        addDepatments();
    }
    @FXML
    void unAddDep(ActionEvent event) {
        unaddDepatments();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDepatments();
    }
    private  ObservableList<DepatmentsModel> getDepatments(){
        ObservableList<DepatmentsModel> depatmentsModelsObservableListl = FXCollections.observableArrayList();
        DataBaseService dataBaseService = new DataBaseService();
        Connection connection = dataBaseService.getConnection();

        String sqlDepatmentsModel = "SELECT id, title, idEmployee FROM `FU_departments`";
        try{

            Statement statementDepatmentsModel = connection.createStatement();
            ResultSet resultSetDepatmentsModel = statementDepatmentsModel.executeQuery(sqlDepatmentsModel);

            while (resultSetDepatmentsModel.next()){
                Integer queryid = resultSetDepatmentsModel.getInt("id");
                Integer queryidEmployee = resultSetDepatmentsModel.getInt("idEmployee");
                String querytitle = resultSetDepatmentsModel.getString("title");
                depatmentsModelsObservableListl.add(new DepatmentsModel(queryid,queryidEmployee,querytitle));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return  depatmentsModelsObservableListl;
    }
    private void setDepatments() {
        ObservableList<DepatmentsModel> depatmentsModelsObservableListl = getDepatments();
        idTable_Depatments1.setCellValueFactory(new PropertyValueFactory<>("id"));
        NumTable_Depatments1.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        NameTable_Depatments1.setCellValueFactory(new PropertyValueFactory<>("title"));
        Table_Depatments1.setItems(depatmentsModelsObservableListl);
    }
    private void addDepatments(){
        String sql ="INSERT INTO FU_departments (title) VALUES ('"+nameTitleDepatment.getText()+"')";
        System.out.println(sql);
        executeSqlEmp(sql);
        setDepatments();

    }
    private  void unaddDepatments(){
        String sql = "DELETE FROM FU_departments WHERE id = ("+delDepatment.getText()+")";
        executeSqlEmp(sql);
        setDepatments();

    }
    private void updateCategory() {
        String sql = "UPDATE FU_departments SET title = '" + RedDownDepatment.getText() + "' WHERE id = " + RedUPDepatment11.getText() + "";
        executeSqlEmp(sql);
        setDepatments();
    }

    private void executeSqlEmp(String sql){
        DataBaseService dataBaseService = new DataBaseService();
        Connection connection = dataBaseService.getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}

