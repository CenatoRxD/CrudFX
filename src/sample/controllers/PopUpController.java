package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Sviatoslav on 18.01.2017.
 */
public class PopUpController {
    private MainController mainController = new MainController();
    private EmployeeDAOImpl dao = new EmployeeDAOImpl();

    @FXML
    private Button btnNo;

    @FXML
    private Button btnYes;

    @FXML
    void delete(ActionEvent event) {
        /*int selectedItem = mainController.getTabViewCollection().getSelectionModel().getFocusedIndex();
        dao.delete(selectedItem);*/
        close(event);

    }

    @FXML
    void cancel(ActionEvent event) {
        close(event);
    }

    private void close(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
