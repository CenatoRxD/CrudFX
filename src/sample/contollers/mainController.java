package sample.contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.interfacesAndClasses.Employee;
import sample.interfacesAndClasses.EmployeeFXImpl;
import sample.interfacesAndClasses.IEmployeeFX;

import java.io.IOException;

public class mainController {

    private IEmployeeFX iEmployeeFX = new EmployeeFXImpl();

    @FXML
    private TableView<Employee> tabViewCollection;

    @FXML
    private TableColumn<Employee, String> columnName;

    @FXML
    private TableColumn<Employee, Integer> columnAge;

    @FXML
    private TableColumn<Employee, Integer> columnSalary;

    @FXML
    private void initialize(){
        iEmployeeFX.add(new Employee("asdf", 12, 25200));
        columnName.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Age"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Salary"));
        tabViewCollection.setItems(iEmployeeFX.getAll());
    }
    @FXML
    public void showAddDialog(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/addDialog.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Add Dialog");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }
    @FXML
    public void showUpdDialog(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/updateDialog.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Add Dialog");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    public void showDelWindow(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/deleteDialog.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Add Dialog");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
