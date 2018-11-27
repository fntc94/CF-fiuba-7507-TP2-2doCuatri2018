package controladores;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import modelo.posicion.*;


public class JuegoController {

    @FXML
    private Label nombreJugador1;

    @FXML
    private Label nombreJugador2;

    @FXML
    private GridPane mapa;

    @FXML
    private Label botonera;

    public void init(String nombreJugador1, String nombreJugador2){

       this.nombreJugador1.setText(nombreJugador1);
       this.nombreJugador2.setText(nombreJugador2);

       try {
           this.llenarMapa();
       }
       catch (Exception e){
           new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
       }

    }

    private void llenarMapa() throws Exception{
        GridPane gridPane = mapa;


        int cantidadFilas = 20;
        int cantidadColumnas = 30;
        int dimCasillero = 50;

        for(int fila = 0; fila <= cantidadFilas - 1; fila++){
            RowConstraints rowConstraints = new RowConstraints(dimCasillero);
            rowConstraints.setFillHeight(true);
            gridPane.getRowConstraints().add(rowConstraints);
        }

        for(int columna = 0; columna <= cantidadColumnas - 1; columna++){
            ColumnConstraints columnConstraints = new ColumnConstraints(dimCasillero);
            columnConstraints.setFillWidth(true);
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        for(int fila = 0; fila <= cantidadFilas - 1; fila++){
            for(int columna = 0; columna <= cantidadColumnas - 1; columna++){
                // agrearCosas
            }
        }

        Posicion posicion = new PosicionDeUnCasillero(2,2);
        Aldeano aldeano = new Aldeano(posicion);

        FXMLLoader aldeanoLoader = new FXMLLoader(getClass().getResource("/vistas/AldeanoView.fxml"));
        Parent vistaAldeano = aldeanoLoader.load();
        AldeanoController aldeanoController = aldeanoLoader.getController();
        aldeanoController.init(this);


        for(Casillero casillero: posicion.getListaCasilleros()){
            int x = casillero.getCoordenadaEnX();
            int y = casillero.getCoordenadaEnY();

            gridPaneRemove(gridPane, x, y);
            gridPane.add(vistaAldeano, x, y);

        }

        gridPane.setGridLinesVisible(true);


    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void gridPaneRemove(GridPane gridPane, int x, int y){
        gridPane.getChildren().remove(getNodeFromGridPane(gridPane, x, y));
    }

    public void setBotonera(String text){
        this.botonera.setText(text);
    }

}
