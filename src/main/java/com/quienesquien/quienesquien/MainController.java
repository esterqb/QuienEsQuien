package com.quienesquien.quienesquien;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ListView<String> rankingBoard;

    @FXML
    private ImageView helpButton;

    @FXML
    private ImageView playButton;

    @FXML
    private TextField username;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rankingBoard.setCellFactory(lv -> new javafx.scene.control.ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("-fx-background-color: transparent;");
                } else {
                    setText(item);
                    setStyle("-fx-font-family: 'Courier New'; " +
                            "-fx-font-weight: bold; " +
                            "-fx-font-size: 23px; " +
                            "-fx-text-fill: white; " +
                            "-fx-background-color: transparent;"+
                            "-fx-alignment: center; ");
                }
            }
        });

        cargarRanking();
    }

    private void cargarRanking() {
        List<String> listaCompleta = RankingManager.obtenerRankingFormateado();
        rankingBoard.getItems().clear();
        for (int i = 0; i < listaCompleta.size() && i < 8; i++) {
            rankingBoard.getItems().add(listaCompleta.get(i));
        }
    }

    @FXML
    void helpClicked(MouseEvent event) {
        ViewManager.mostrarAyuda();
    }

    @FXML
    void playClicked(MouseEvent event) {
        String nombreUsuario=username.getText();
        if(nombreUsuario ==null||nombreUsuario.trim().isEmpty()){
            System.out.println("Introduce un nombre");
            return;
        }
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("play-view.fxml"));
            Parent root=loader.load();
            PlayController controller = loader.getController();
            controller.setNombreUsuario(nombreUsuario);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
