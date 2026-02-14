package com.quienesquien.quienesquien;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ViewManager {

    public static void mostrarAyuda() {
        try {
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource("help-view.fxml"));
            Parent root = loader.load();
            Stage helpStage = new Stage();
            helpStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root);

            scene.setFill(Color.TRANSPARENT);
            helpStage.initStyle(StageStyle.TRANSPARENT);

            helpStage.setScene(scene);
            helpStage.initModality(Modality.APPLICATION_MODAL);
            helpStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}