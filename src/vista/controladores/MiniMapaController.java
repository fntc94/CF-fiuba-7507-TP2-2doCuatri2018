package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.IPosicionable;
import modelo.juego.Jugador;
import modelo.posicion.Casillero;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import vista.controles.JuegoControl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MiniMapaController implements Initializable {

    private final JuegoControl juegoControl;
    private final Mapa mapa;

    private Map<IPosicionable, Node> vistas = new HashMap();
    private Map<IPosicionable, String> colores = new HashMap();

    @FXML
    private GridPane gridPane;

    public MiniMapaController(JuegoControl juegoControl, Mapa mapa){

        this.juegoControl = juegoControl;
        this.mapa = mapa;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inicializarMapaVacio();
        this.dibujar();
    }

    private void inicializarMapaVacio() {

        int cantidadFilas = this.mapa.getAlto();
        int cantidadColumnas = this.mapa.getAncho();
        int dimCasillero = 7;

        for (int fila = 0; fila <= cantidadFilas - 1; fila++) {
            RowConstraints rowConstraints = new RowConstraints(dimCasillero);
            rowConstraints.setFillHeight(true);
            this.gridPane.getRowConstraints().add(rowConstraints);
        }

        for (int columna = 0; columna <= cantidadColumnas - 1; columna++) {
            ColumnConstraints columnConstraints = new ColumnConstraints(dimCasillero);
            columnConstraints.setFillWidth(true);
            this.gridPane.getColumnConstraints().add(columnConstraints);
        }

        for (int fila = 0; fila <= cantidadFilas - 1; fila++) {
            for (int columna = 0; columna <= cantidadColumnas - 1; columna++) {

            }
        }

        this.gridPane.setGridLinesVisible(true);
    }

    public void agregar(IPosicionable posicionable, String color){
        this.colores.put(posicionable,color);
        this.dibujar(posicionable);
    }

    public void dibujar() {

        this.gridPane.getChildren().removeAll(this.vistas.values());

        for (IPosicionable posicionable : this.mapa) {
            this.dibujar(posicionable);
        }

    }

    private void dibujar(IPosicionable posicionable) {


        Posicion posicion = posicionable.getPosicion();
        Casillero abajoIzquierda = posicion.getAbajoIzquierda();

        AnchorPane vista = new AnchorPane();
        String css = String.format("-fx-background-color: %s", this.colores.get(posicionable));
        vista.setStyle(css);

        this.gridPane.add(vista, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

        GridPane.setColumnSpan(vista, posicion.getAncho());
        GridPane.setRowSpan(vista, posicion.getAlto());

        this.vistas.put(posicionable, vista);

    }

}
