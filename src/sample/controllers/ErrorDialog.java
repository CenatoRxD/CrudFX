package sample.controllers;

import javafx.scene.control.Alert;

/**
 * @author Sviatoslav
 */
public class ErrorDialog {
    /**
     * Static method whose will showing error window.
     *
     * @param title - title error window;
     * @param txt   - error massage.
     */
    public static void showErrorDialog(String title, String txt) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(txt);
        alert.setHeaderText("");
        alert.showAndWait();
    }
}
