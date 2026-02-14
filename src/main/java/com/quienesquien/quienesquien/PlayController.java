package com.quienesquien.quienesquien;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class PlayController implements Initializable {
    private Personaje personajeSecreto;
    private List<Personaje> listaPersonajes = new ArrayList<>();
    private boolean modoAdivinar = false;
    private int puntuacionActual = 15000;
    private final int PENALIZACION = 800;
    private String nombreUsuario;

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }
    @FXML
    private ImageView helpButton;

    @FXML
    private ComboBox<String> preguntas;

    @FXML
    private Label respuesta;

    @FXML
    private ImageView guessButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preguntas.getItems().addAll(
                "¿Tiene el pelo negro?",
                "¿Tiene el pelo castaño?",
                "¿Tiene el pelo rubio?",
                "¿Tiene el pelo rojo?",
                "¿Tiene el pelo blanco?",
                "¿Tiene los ojos azules?",
                "¿Tiene los ojos marrones?",
                "¿Lleva gafas?",
                "¿Es hombre?",
                "¿Es mujer?",
                "¿Es calvo?",
                "¿Está serio?",
                "¿Tiene bigote o barba?",
                "¿Tiene un hoyuelo en la barbilla?",
                "¿Lleva sombrero o gorra?"
        );

        cargarPersonajes();
        Random random = new Random();
        personajeSecreto = listaPersonajes.get(random.nextInt(listaPersonajes.size()));
        puntuacionActual -= PENALIZACION;
        if (puntuacionActual < 0) puntuacionActual = 0;
    }

    @FXML
    void preguntaSeleccionada(ActionEvent event) {
        String seleccion = preguntas.getValue();
        if (seleccion == null) return;
        puntuacionActual -= PENALIZACION;
        if (puntuacionActual < 0) puntuacionActual = 0;
        boolean respuestaBoolean = false;

        switch (seleccion) {
            case "¿Tiene el pelo negro?": respuestaBoolean = personajeSecreto.getColorPelo().equals("negro"); break;
            case "¿Tiene el pelo castaño?": respuestaBoolean = personajeSecreto.getColorPelo().equals("castaño"); break;
            case "¿Tiene el pelo rubio?": respuestaBoolean = personajeSecreto.getColorPelo().equals("rubio"); break;
            case "¿Tiene el pelo rojo?": respuestaBoolean = personajeSecreto.getColorPelo().equals("pelirrojo"); break;
            case "¿Tiene el pelo blanco?": respuestaBoolean = personajeSecreto.getColorPelo().equals("blanco"); break;
            case "¿Tiene los ojos azules?": respuestaBoolean = personajeSecreto.getColorOjos().equals("azules"); break;
            case "¿Tiene los ojos marrones?": respuestaBoolean = personajeSecreto.getColorOjos().equals("marrones"); break;
            case "¿Lleva gafas?": respuestaBoolean = personajeSecreto.isTieneGafas(); break;
            case "¿Es hombre?": respuestaBoolean = personajeSecreto.isEsHombre(); break;
            case "¿Es mujer?": respuestaBoolean = !personajeSecreto.isEsHombre(); break;
            case "¿Es calvo?": respuestaBoolean = !personajeSecreto.isTienePelo(); break;
            case "¿Está serio?": respuestaBoolean = personajeSecreto.isEstaSerio(); break;
            case "¿Tiene bigote o barba?": respuestaBoolean = personajeSecreto.isTieneBarba(); break;
            case "¿Tiene un hoyuelo en la barbilla?": respuestaBoolean = personajeSecreto.isTieneBarbilla(); break;
            case "¿Lleva sombrero o gorra?": respuestaBoolean = personajeSecreto.isTieneGorro(); break;
        }
        if (respuestaBoolean) {
            respuesta.setText("SÍ");
        } else {
            respuesta.setText("NO");
        }
        System.out.println("Pregunta: " + seleccion + " | respuestaBoolean: " + (respuestaBoolean ? "SÍ" : "NO"));
    }

    private void cargarPersonajes() {
        // FILA 1
        listaPersonajes.add(new Personaje("Jorge Nitales", "negro", "marrones", false, true, true, true, false, false, true));
        listaPersonajes.add(new Personaje("Mike Okslong", "pelirrojo", "azules", false, true, true, true, false, false, false));
        listaPersonajes.add(new Personaje("Debora Melnavo", "rubio", "azules", false, false, false, true, false, false, false));
        listaPersonajes.add(new Personaje("Sor Raimunda", "negro", "marrones", false, false, false, false, true, false, false));
        listaPersonajes.add(new Personaje("Felipe Neduro", "castaño", "marrones", false, true, false, true, true, true, true));
        listaPersonajes.add(new Personaje("Tomas Desta", "pelirrojo", "marrones", false, true, true, false, false, false, false));
        listaPersonajes.add(new Personaje("Isidro Gamos Alcura", "rubio", "marrones", false, true, true, true, false, false, false));
        listaPersonajes.add(new Personaje("Elba Ginazzo", "rubio", "marrones", true, false, false, true, true, false, false));
        // FILA 2
        listaPersonajes.add(new Personaje("Aquiles Castro", "rubio", "marrones", false, true, true, true, false, false, false));
        listaPersonajes.add(new Personaje("Dixon Myas", "rubio", "marrones", false, true, false, true, true, false, true));
        listaPersonajes.add(new Personaje("Fermin Gadura", "pelirrojo", "marrones", false, true, false, true, false, false, false));
        listaPersonajes.add(new Personaje("Pedro Gado", "blanco", "marrones", false, true, false, true, true, true, true));
        listaPersonajes.add(new Personaje("Alberto Catetas", "pelirrojo", "marrones", false, true, false, false, false, true, false));
        listaPersonajes.add(new Personaje("Jeffrey Epstein", "rubio", "marrones", true, true, false, true, false, false, true));
        listaPersonajes.add(new Personaje("Jenny Tales", "castaño", "marrones", false, false, false, true, true, false, false));
        listaPersonajes.add(new Personaje("Haaland Omeló", "negro", "marrones", false, true, true, true, false, false, false));
        // FILA 3
        listaPersonajes.add(new Personaje("Lotten Gogordo", "blanco", "marrones", true, true, false, true, false, false, true));
        listaPersonajes.add(new Personaje("Elfo Yeteo", "blanco", "azules", false, true, false, true, false, false, false));
        listaPersonajes.add(new Personaje("Kenny Galindo", "negro", "marrones", false, true, true, true, false, false, false));
        listaPersonajes.add(new Personaje("Rodolfo Llado", "castaño", "marrones", false, true, true, false, false, false, false));
        listaPersonajes.add(new Personaje("Keppin Gotte", "castaño", "azules", false, true, false, true, false, true, true));
        listaPersonajes.add(new Personaje("Teorino Elollo", "blanco", "marrones", true, true, false, false, false, false, false));
        listaPersonajes.add(new Personaje("Ramonica Hall", "blanco", "marrones", false, false, false, true, false, false, false));
        listaPersonajes.add(new Personaje("Elmas Kapoyas", "negro", "azules", true, true, false, false, false, false, false));
    }

    @FXML
    void guessClicked(MouseEvent event) {
        modoAdivinar = !modoAdivinar;

        if (modoAdivinar) {
            guessButton.setOpacity(0.5);
            respuesta.setText("¿Quién es?");
        } else {
            guessButton.setOpacity(1.0);
            respuesta.setText("");
        }
    }

    @FXML
    void descartarPersonaje(MouseEvent event) {
        VBox cajaPersonaje = (VBox) event.getSource();

        if (modoAdivinar) {
            Label labelNombre = (Label) cajaPersonaje.getChildren().get(1);
            String nombreClicado = labelNombre.getText().trim();

            if (nombreClicado.equalsIgnoreCase(personajeSecreto.getNombre().trim())) {
                Jugador ganador = new Jugador(nombreUsuario, puntuacionActual);
                RankingManager.guardarPuntuacion(ganador);
                cargarEscenaVictoria(ganador);
            } else {
                cambiarEscena("lose-view.fxml");
            }
        } else {
            if (cajaPersonaje.getOpacity() == 1.0) {
                cajaPersonaje.setOpacity(0.4);
                ImageView img = (ImageView) cajaPersonaje.getChildren().get(0);
                ColorAdjust oscurecer = new ColorAdjust();
                oscurecer.setBrightness(-0.5);
                img.setEffect(oscurecer);
            } else {
                cajaPersonaje.setOpacity(1.0);
                ImageView img = (ImageView) cajaPersonaje.getChildren().get(0);
                img.setEffect(null);
            }
        }
    }

    private void cargarEscenaVictoria(Jugador ganador) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("win-view.fxml"));
            javafx.scene.Parent root = loader.load();

            WinController controller = loader.getController();
            controller.mostrarResultados(ganador.getNombre(), ganador.getPuntos());

            javafx.stage.Stage stage = (javafx.stage.Stage) guessButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    private void cambiarEscena(String fxml) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxml));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) guessButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void helpClicked(MouseEvent event) {
        ViewManager.mostrarAyuda();
    }
}
