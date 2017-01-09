package sample.contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class MainController {

    EmployeeDAOImpl dao = new EmployeeDAOImpl();

    @FXML
    private TableView<Employee> tabViewCollection;

    @FXML
    private TableColumn<Employee, Integer> columnID;

    @FXML
    private TableColumn<Employee, String> columnName;

    @FXML
    private TableColumn<Employee, Integer> columnAge;

    @FXML
    private TableColumn<Employee, Integer> columnSalary;

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
        columnID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("age"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        dao.add(new Employee("adf", 151, 15));
        dao.add(new Employee("adf", 151, 15));
        dao.add(new Employee("adf", 151, 15));
    }

    private Employee getEmp() throws IOException {
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        int salary = Integer.parseInt(txtSalary.getText());
        return new Employee(name, age, salary);
    }

    public void add(ActionEvent actionEvent) throws IOException {
        dao.add(getEmp());
        tabViewCollection.setItems(dao.getEmployees());
        txtName.clear();
        txtAge.clear();
        txtSalary.clear();
    }

    public void delete(ActionEvent actionEvent) {
    }


    public void getAll(ActionEvent actionEvent) {
        tabViewCollection.setItems(dao.getAll());
    }
}
