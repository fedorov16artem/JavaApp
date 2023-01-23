package com.example.comapy.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.comapy.models.DB;

import com.example.comapy.services.ButtonSevices;
import com.example.comapy.services.DataBaseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;


public class controller implements Initializable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private MenuItem AuthorEmployee;
    @FXML
    private MenuItem BDEmployee;
    @FXML
    private MenuItem ProgrammEmployee;
    @FXML
    private Button unaddEmployee;
    @FXML
    private Button ButtonEmployee;
    @FXML
    private Button addEmployee;
    @FXML
    private TableColumn<DB, String> NSPtableEmployee;
    @FXML
    private TableColumn<DB, Integer> NumbarTableEmployee;
    @FXML
    private TextField StringIDEmployee;
    @FXML
    private TextField StringOtdelEmployee;

    @FXML
    private TableView<DB> Table_Emploeys;
    @FXML
    private TableColumn<DB, Double> ZPtableEmployee;
    @FXML
    private TableColumn<DB, Integer> ageTableEmployee;
    @FXML
    private TableColumn<DB, Integer> idTableEmployee;
    @FXML
    private TableColumn<DB, String> titleTableEmployee;

    @FXML
    void BTEM(ActionEvent event) throws IOException {
        ButtonSevices buttonSevices = new ButtonSevices();
        buttonSevices.ButtonSwitch("/com/example/comapy/Employee.fxml", event, "Сотрудники");
    }

    @FXML
    void OTEM(ActionEvent event) throws IOException {
        ButtonSevices buttonSevices = new ButtonSevices();
        buttonSevices.ButtonSwitch("/com/example/comapy/SingUP.fxml", event, "Отдел");
    }

    @FXML
    void addEM(ActionEvent event) {
        if(event.getSource()== addEmployee){
            addEmployee();
        }
    }

    @FXML
    void UNadd(ActionEvent event) {
        unaddEmployee();
    }
    @FXML
    void UEB(ActionEvent event) {
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDB();
    }

    private ObservableList<DB> getDB() {
        ObservableList<DB> dbObservableList = FXCollections.observableArrayList();
        DataBaseService dataBaseService = new DataBaseService();
        Connection connection = dataBaseService.getConnection();
        String sqlDB = "SELECT FU_employees.id AS id, FU_employees.name AS name, FU_employees.age AS age, FU_employees.wages AS wages, FU_departments.title AS title,FU_departments.idEmployee AS idEmployee  FROM FU_employees INNER JOIN FU_departments ON FU_departments.idEmployee = FU_employees.id";

        try {
            Statement statementDPModel = connection.createStatement();
            ResultSet resultSetDBModel = statementDPModel.executeQuery((sqlDB));

            while (resultSetDBModel.next()) {
                Integer queryid = resultSetDBModel.getInt("id");
                Integer queryage = resultSetDBModel.getInt("age");
                String querytitle = resultSetDBModel.getString("title");
                String queryname = resultSetDBModel.getString("name");
                Double quarywages = resultSetDBModel.getDouble("wages");
                Integer quaryidEmployee = resultSetDBModel.getInt("idEmployee");
                dbObservableList.add(new DB(queryid, queryage, querytitle, queryname, quarywages,quaryidEmployee));
            }

        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return dbObservableList;
        }
        private void setDB(){
        ObservableList<DB> dbObservableList = getDB();
        idTableEmployee.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageTableEmployee.setCellValueFactory(new PropertyValueFactory<>("age"));
        titleTableEmployee.setCellValueFactory(new PropertyValueFactory<>("title"));
        NSPtableEmployee.setCellValueFactory(new PropertyValueFactory<>("name"));
        ZPtableEmployee.setCellValueFactory(new PropertyValueFactory<>("wages"));
        NumbarTableEmployee.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        Table_Emploeys.setItems(dbObservableList);
        }
        private void addEmployee(){
            String sql ="INSERT INTO FU_departments(title) VALUES ("+StringIDEmployee.getText()+")";
            executeSql(sql);
            setDB();

        }
        private  void unaddEmployee(){
            String sql = "DELETE FROM FU_departments WHERE id = ("+StringIDEmployee.getText()+")";
            executeSql(sql);
            setDB();

        }
        private void executeSql(String sql){
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






