package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelo.juego.Jugador;
import vista.controles.JuegoControl;
import vista.controles.MapaControl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Label oroJugadorUno;

    @FXML
    private Label oroJugadorDos;

    @FXML
    private Label poblacionJugadorUno;

    @FXML
    private Label poblacionJugadorDos;

    Map<String, Label> labelsOro = new HashMap<>();
    Map<String, Label> labelsPoblacion = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void actualizarOro(Jugador jugadorActual, String color) {
        jugadorActual.trabajar();

        int cantidadOro = jugadorActual.getOro();

        if(this.labelsOro.get("red") == null) {
            this.labelsOro.put("red", this.oroJugadorUno);
            this.labelsOro.put("blue", this.oroJugadorDos);
        }

        Label labelOro = this.labelsOro.get(color);

        labelOro.setText(Integer.toString(cantidadOro));
    }

    public void actualizarPoblacion(int poblacionJugador1, int poblacionJugador2){

        if(this.labelsPoblacion.get("red") == null){
            this.labelsPoblacion.put("red",this.poblacionJugadorUno);
            this.labelsPoblacion.put("blue",this.poblacionJugadorDos);
        }

        this.poblacionJugadorUno.setText(Integer.toString(poblacionJugador1));
        this.poblacionJugadorDos.setText(Integer.toString(poblacionJugador2));
    }

    public void actualizarPoblacion(int cantidadDePoblacion, String color) {
        if(this.labelsPoblacion.get("red") == null){
            this.labelsPoblacion.put("red",this.poblacionJugadorUno);
            this.labelsPoblacion.put("blue",this.poblacionJugadorDos);
        }

        Label labelPoblacion = this.labelsPoblacion.get(color);

        labelPoblacion.setText(Integer.toString(cantidadDePoblacion));
    }
}
