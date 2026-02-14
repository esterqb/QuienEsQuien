package com.quienesquien.quienesquien;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class WinController {

    @FXML
    private ImageView helpButton;

    @FXML
    private Label playAgain;

    @FXML
    private Label puntos;

    @FXML
    private Label salir;

    @FXML
    private Label username;

    public void mostrarResultados(String nombre, int puntuacionFinal) {
        username.setText(nombre);
        puntos.setText(String.valueOf(puntuacionFinal) + " pts");
    }
    @FXML
    void helpClicked(MouseEvent event) {
        ViewManager.mostrarAyuda();
    }

    @FXML
    void playAgain(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) playAgain.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }
}
