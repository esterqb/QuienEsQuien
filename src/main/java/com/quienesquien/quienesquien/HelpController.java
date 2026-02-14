package com.quienesquien.quienesquien;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HelpController {

    @FXML
    private ImageView okButton;

    @FXML
    void okClicked(MouseEvent event) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}