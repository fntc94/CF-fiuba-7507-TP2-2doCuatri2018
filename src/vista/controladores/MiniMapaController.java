package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.IPosicionable;
import modelo.posicion.Casillero;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import vista.controles.JuegoControl;
import vista.controles.PosicionableVista;

import java.net.URL;
import java.util.*;

public class MiniMapaController implements Initializable {

    private final JuegoControl juegoControl;
    private final Mapa mapa;


    Collection<PosicionableVista> vistas = new ArrayList<>();
    Map<PosicionableVista, Node> vistasSimplificadas = new HashMap<>();

    @FXML
    private GridPane gridPane;

    public MiniMapaController(JuegoControl juegoControl, Mapa mapa){

        this.juegoControl = juegoControl;
        this.mapa = mapa;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inicializarMapaVacio();
//        this.dibujar();
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


    public void agregar(PosicionableVista vista){
        AnchorPane vistaSimplificada = new AnchorPane();
        String css = String.format("-fx-background-color: %s", vista.getController().getColor());
        vistaSimplificada.setStyle(css);

        this.vistas.add(vista);
        this.vistasSimplificadas.put(vista, vistaSimplificada);
    }

    public void remover(PosicionableVista vista){
        this.vistas.remove(vista);

        Node vistaSimplificada = this.vistasSimplificadas.get(vista);
        this.gridPane.getChildren().remove(vistaSimplificada);
        this.vistasSimplificadas.remove(vista);


    }

    public void dibujar() {

        this.gridPane.getChildren().removeAll(this.vistasSimplificadas.values());

        for(PosicionableVista vista: this.vistas){
            this.dibujarVistaSimplificada(vista);
        }

    }

    private void dibujarVistaSimplificada(PosicionableVista vista){

        Node vistaSimplificada = this.vistasSimplificadas.get(vista);

        IPosicionableController controlador = vista.getController();
        Posicion posicion = controlador.getPosicion();
        Casillero abajoIzquierda = posicion.getAbajoIzquierda();
        int columna = abajoIzquierda.getCoordenadaEnX();
        int fila = abajoIzquierda.getCoordenadaEnY();

        this.gridPane.add(vistaSimplificada, columna, fila);
        GridPane.setColumnSpan(vistaSimplificada, posicion.getAncho());
        GridPane.setRowSpan(vistaSimplificada, posicion.getAlto());
    }

}
