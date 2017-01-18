package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Sviatoslav on 18.01.2017.
 */
public class popUpController {
    MainController main = new MainController();
    private EmployeeDAOImpl dao = new EmployeeDAOImpl();
    private Stage stage;

    @FXML
    private Button btnNo;

    @FXML
    private Button btnYes;

    @FXML
    void delete(ActionEvent event) {
        stage = (Stage) btnYes.getScene().getWindow();
        stage.close();

    }

    @FXML
    void cancel(ActionEvent event) {
        stage = (Stage) btnNo.getScene().getWindow();
        stage.close();
    }
}
