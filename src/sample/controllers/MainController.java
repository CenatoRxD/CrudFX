package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for realization any actions in UI.
 *
 * @author Sviatoslav
 */
public class MainController {

    private EmployeeDAOImpl dao = new EmployeeDAOImpl();
    private Stage mainStage;

    @FXML
    private TableView<Employee> tabViewCollection;

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
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dao.add(new Employee("q", "1", "15"));
        dao.add(new Employee("w", "2", "15222"));
        dao.add(new Employee("e", "3", "3333"));
        dao.add(new Employee("r", "4", "4444"));

        tabViewCollection.setItems(dao.getEmployees());
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAge.setCellFactory(TextFieldTableCell.forTableColumn());
        columnSalary.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    /**
     * Method for creating employees.
     *
     * @return new employee
     */
    private Employee getEmp() {
        String name = txtName.getText();
        String age = txtAge.getText();
        String salary = txtSalary.getText();
        return new Employee(name, age, salary);
    }


    /**
     * Method adding new employee in database.
     *
     * @param actionEvent - click on button "add".
     */

    @FXML
    public void add(ActionEvent actionEvent) {
        if (!validAdd()) {
            return;
        }
        dao.add(getEmp());
        txtName.clear();
        txtAge.clear();
        txtSalary.clear();
    }

    /**
     * Method delete selected employee.
     *
     * @param actionEvent - click on button " delete".
     */
    @FXML
    public void delete(ActionEvent actionEvent) throws IOException {
        int selectedItem = tabViewCollection.getSelectionModel().getSelectedIndex();
        if (!validDelete(selectedItem)) {
            return;
        }
        dao.delete(selectedItem);
    }

    /**
     * Method for getting all employees from database.
     *
     * @param actionEvent - click on button "get All".
     */
    @FXML
    public void getAll(ActionEvent actionEvent) {
        tabViewCollection.setItems(dao.getAll());
    }

    /**
     * @param editName - section in Name's row were we will changing name of employee.
     */
    public void changeName(TableColumn.CellEditEvent<Employee, String> editName) {
        editName.getTableView().
                getItems().
                get(editName.getTablePosition().getRow()).
                setName(editName.getNewValue());
    }

    /**
     * @param editAge - section in Age's row were we will changing age of employee.
     */
    public void editAge(TableColumn.CellEditEvent<Employee, String> editAge) {
        editAge.getTableView().
                getItems().get(editAge.getTablePosition().getRow()).
                setAge(editAge.getNewValue());
    }

    /**
     * @param editSalary - section in Salary's row were we will changing salary of employee.
     */
    public void editSalary(TableColumn.CellEditEvent<Employee, String> editSalary) {
        editSalary.getTableView().
                getItems().get(editSalary.getTablePosition().getRow()).
                setSalary(editSalary.getNewValue());
    }

    /**
     * Validation for button "add".
     *
     * @return - true, if user correct filled text field;
     * false, if text field filled incorrect and show ErrorDialog.
     * @see ErrorDialog
     */
    private boolean validAdd() {

        if (txtName.getText().trim().length() == 0 ||
                txtAge.getText().trim().length() == 0 ||
                txtSalary.getText().trim().length() == 0) {
            ErrorDialog.showErrorDialog("Error!!!", "Fill all fields");
            return false;
        } else if (!txtAge.getText().matches("[0-9]*")) {
            ErrorDialog.showErrorDialog("Error!!!", "Incorrect Age, write number 0 - 9 ");
            return false;
        } else if (!txtSalary.getText().matches("[0-9]*")) {
            ErrorDialog.showErrorDialog("Error!!!", "Incorrect Salary, write number 0 - 9 ");
            return false;
        }
        return true;
    }

    /**
     * Validation for button "delete".
     *
     * @param selectedItem - employee whose will deleting.
     * @return - - true, if user selected any employee;
     * false, if user don't select employee in database and show ErrorDialog.
     * @see ErrorDialog
     */
    private boolean validDelete(int selectedItem) {
        if (selectedItem == -1) {
            ErrorDialog.showErrorDialog("Error!!!", "Select some Employee");
            return false;
        }
        return true;
    }

}
