package controladores;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class JuegoController {

    @FXML
    private Label nombreJugador1;

    @FXML
    private Label nombreJugador2;

    @FXML
    private GridPane mapa;

    public void init(String nombreJugador1, String nombreJugador2){

       this.nombreJugador1.setText(nombreJugador1);
       this.nombreJugador2.setText(nombreJugador2);

       this.llenarMapa();

    }

    private void llenarMapa(){
        GridPane gridPane = mapa;
        gridPane.alignmentProperty().setValue(Pos.CENTER);

        int ancho = 40;
        int alto = 20;

        for(int i = 0; i <= ancho; i++){
            for(int j = 0; j<= alto; j++){
                Label l = new Label();
                l.setText("#");
                gridPane.add(l, i, j);
            }
        }

        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

}
