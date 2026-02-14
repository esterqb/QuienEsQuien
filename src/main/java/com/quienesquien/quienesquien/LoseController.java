package com.quienesquien.quienesquien;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoseController {

    @FXML
    private ImageView helpButton;

    @FXML
    private Pane noButton;

    @FXML
    private Pane yesButton;

    @FXML
    void helpClicked(MouseEvent event) {
        ViewManager.mostrarAyuda();
    }

    @FXML
    void noClicked(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void yesClicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) yesButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
