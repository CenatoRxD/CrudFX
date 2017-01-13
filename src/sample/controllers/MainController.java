package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;


public class MainController {

    private EmployeeDAOImpl dao = new EmployeeDAOImpl();

    @FXML
    private TableView<Employee> tabViewCollection;

    @FXML
    private TableColumn<Employee, String> columnID;

    @FXML
    private TableColumn<Employee, String> columnName;

    @FXML
    private TableColumn<Employee, String> columnAge;

    @FXML
    private TableColumn<Employee, String> columnSalary;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtSalary;

    @FXML
    private Button buttonAdd;

    @FXML
    Button buttonDelete;

    @FXML
    Button buttonGetAll;

    @FXML
    private void initialize() {
        txtName.setPromptText("Name");
        txtAge.setPromptText("Age");
        txtSalary.setPromptText("Salary");
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dao.add(new Employee("adf", "151", "15"));
        dao.add(new Employee("adf", "151", "15"));
        dao.add(new Employee("adf", "151", "15"));
        dao.add(new Employee("adf", "151", "15"));

        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAge.setCellFactory(TextFieldTableCell.forTableColumn());
        columnSalary.setCellFactory(TextFieldTableCell.forTableColumn());


    }

    private Employee getEmp() throws IOException {
        String name = txtName.getText();
        String age = txtAge.getText();
        String salary = txtSalary.getText();
        return new Employee(name, age, salary);
    }

    public void add(ActionEvent actionEvent) throws IOException {
        dao.add(getEmp());
        //tabViewCollection.setItems(dao.getEmployees());
        txtName.clear();
        txtAge.clear();
        txtSalary.clear();
    }

    public void delete(ActionEvent actionEvent) {
        int selectedItem = tabViewCollection.getSelectionModel().getSelectedIndex();
        //tabViewCollection.getItems().remove(dao.getEmployees().remove(selectedItem));
        dao.delete(selectedItem);
    }

    public void getAll(ActionEvent actionEvent) {
        tabViewCollection.setItems(dao.getAll());
    }

    public void changeName(TableColumn.CellEditEvent<Employee, String> editName) {
        editName.getTableView().
                getItems().
                get(editName.getTablePosition().getRow()).
                setName(editName.getNewValue());
    }

    public void editAge(TableColumn.CellEditEvent<Employee, String> editAge) {
        editAge.getTableView().
                getItems().get(editAge.getTablePosition().getRow()).
                setAge(editAge.getNewValue());
    }

    public void editSalary(TableColumn.CellEditEvent<Employee, String> editSalary) {
        editSalary.getTableView().
                getItems().get(editSalary.getTablePosition().getRow()).
                setSalary(editSalary.getNewValue());
    }
}
