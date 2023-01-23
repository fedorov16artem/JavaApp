package com.example.comapy.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.comapy.models.EmployeesModel;
import com.example.comapy.services.ButtonSevices;
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


public class Office implements Initializable {

    @FXML
    private Button BDEmployes;
    @FXML
    private TextField FIOEmployess;

    @FXML
    private TextField DelEmployess1;
    @FXML
    private TextField IDEmployess;
    @FXML
    private TextField ZPEmployess;

    @FXML
    private TextField RedAGEEmployess;
    @FXML
    private TextField RedwagesEmployess;
    @FXML
    private TextField RedFIOEmployess;
    @FXML
    private Button KnopkaOtdel;
    @FXML
    private TextField RedDownEmployess;
    @FXML
    private TextField ageEmployess;
    @FXML
    private Button RedEmployees;
    @FXML
    private TextField RedUPEmployess;
    @FXML
    private TextField ZPsumEmployees;

    @FXML
    private Button addEmployes1;

    @FXML
    private Button unaddEmploees;
    @FXML
    private TableColumn<EmployeesModel, String> FIOTable_Emploeys1;
    @FXML
    private TableView<EmployeesModel> Table_Emploeys1;
    @FXML
    private TableColumn<EmployeesModel, Integer> ZPTable_Emploeys1;
    @FXML
    private TableColumn<EmployeesModel, Integer> ageTable_Emploeys1;
    @FXML
    private TableColumn<EmployeesModel, Integer> idTable_Emploeys1;


    @FXML
    void KOT(ActionEvent event) throws IOException {
        ButtonSevices buttonSevices = new ButtonSevices();
        buttonSevices.ButtonSwitch("/com/example/comapy/SingUP.fxml", event, "Отдел");

    }
    @FXML
    void BDE(ActionEvent event) throws IOException {
        ButtonSevices buttonSevices = new ButtonSevices();
        buttonSevices.ButtonSwitch("/com/example/comapy/hello-view.fxml", event, "Отдел");
    }
    @FXML
    void RedE(ActionEvent event) {
        updateEmployee();
    }



    @FXML
    void addEmp(ActionEvent event) {
        addEmployee();

    }

    @FXML
    void unaddEmployes(ActionEvent event) {
        unaddEmployee();

    }

    @FXML
    void ZpSUm(ActionEvent event) {
        SumZp();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEmploeys();
    }
    private ObservableList<EmployeesModel> getEmployed(){
        ObservableList<EmployeesModel> employeesModelObservableListl = FXCollections.observableArrayList();
        DataBaseService dataBaseService = new DataBaseService();
        Connection connection = dataBaseService.getConnection();

        String sqlEmployeesModel = "SELECT id, name, age, wages FROM `FU_employees`";
        try{
            Statement statementEmployeesModel = connection.createStatement();
            ResultSet resultSetEmployeesModel = statementEmployeesModel.executeQuery(sqlEmployeesModel);

            while (resultSetEmployeesModel.next()){
                Integer queryid = resultSetEmployeesModel.getInt("id");
                Integer quryage = resultSetEmployeesModel.getInt("age");
                Double quarywages = resultSetEmployeesModel.getDouble("wages");
                String queryname = resultSetEmployeesModel.getString("name");
                employeesModelObservableListl.add(new EmployeesModel(queryid,quryage,quarywages,queryname));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employeesModelObservableListl;
    }
    private  void setEmploeys() {
        ObservableList<EmployeesModel> employeesModelObservableListl = getEmployed();

        idTable_Emploeys1.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageTable_Emploeys1.setCellValueFactory(new PropertyValueFactory<>("age"));
        ZPTable_Emploeys1.setCellValueFactory(new PropertyValueFactory<>("wages"));
        FIOTable_Emploeys1.setCellValueFactory(new PropertyValueFactory<>("name"));
        Table_Emploeys1.setItems(employeesModelObservableListl);
    }
    private void addEmployee(){
        String sql ="INSERT INTO FU_employees(name,age,wages) VALUES ('"+ FIOEmployess.getText() + "','"+ageEmployess.getText()+"',"+ZPEmployess.getText()+")";
        executeSqlB(sql);
        setEmploeys();

    }
    private  void unaddEmployee(){
        String sql = "DELETE FROM FU_employees WHERE id = "+ DelEmployess1.getText() +"";
        executeSqlB(sql);
        setEmploeys();

    }
    private void updateEmployee() {
        String sql = "UPDATE FU_employees SET name = '" + RedFIOEmployess.getText() + "',age = '" + RedAGEEmployess.getText() + "',age = " + RedwagesEmployess.getText() + " WHERE id = " + IDEmployess.getText() + "";
        System.out.println(sql);
        executeSqlB(sql);
        setEmploeys();

    }

    public  void SumZp(){
        String sql = "SELECT SUM wages from FU_employees";
        executeSqlB(sql);
        setEmploeys();

    }



    private void executeSqlB(String sql){
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

