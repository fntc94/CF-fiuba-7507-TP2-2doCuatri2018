package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelo.juego.Jugador;
import vista.controles.JuegoControl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    /*
    * En la linea 75 y 76 de JuegoControl se inicializa MenuController y
    * se asigna a una variable private de JuegoControl
    * */

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

    public void init(){
        this.labelsOro.put("rojo", this.oroJugadorUno);
        this.labelsOro.put("blue", this.oroJugadorDos);

        this.labelsPoblacion.put("rojo", poblacionJugadorUno);
        this.labelsPoblacion.put("blue", poblacionJugadorDos);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void actualizarEstadistica(Jugador jugadorActual, String color) {
        jugadorActual.trabajar();

        Label labelOro = this.labelsOro.get(color);

        /* El siguiente if esta porque por alguna razon oroJugadorUno es null
         * init() se llama en la linea 120 de JuegoControl
         * este metodo donde esta escrito este mismo comentario se llama en la linea 213
        */
        if(labelOro == null) {
            this.labelsOro.put("red", this.oroJugadorUno);
            labelOro = this.labelsOro.get(color);
        }

        jugadorActual.mostrarOro(labelOro);
    }
}
