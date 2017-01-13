package sample.controllers;

import javafx.scene.control.Alert;

/**
 * Created by Sviatoslav on 13.01.2017.
 */
public class ErrorDialog {
    public static void showErrorDialog(String title, String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(txt);
        alert.setHeaderText("");
        alert.showAndWait();
    }
}
