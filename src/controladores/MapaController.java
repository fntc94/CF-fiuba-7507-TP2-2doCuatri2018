package controladores;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.Unidad;
import modelo.posicion.Casillero;

public class MapaController extends GridPane {

    private GridPane mapa;

    public void init(GridPane mapa){
        this.mapa = mapa;

        try {
            this.llenarMapa();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
    }

    private void llenarMapa() {

        int cantidadFilas = 20;
        int cantidadColumnas = 30;
        int dimCasillero = 50;

        for(int fila = 0; fila <= cantidadFilas - 1; fila++){
            RowConstraints rowConstraints = new RowConstraints(dimCasillero);
            rowConstraints.setFillHeight(true);
            this.mapa.getRowConstraints().add(rowConstraints);
        }

        for(int columna = 0; columna <= cantidadColumnas - 1; columna++){
            ColumnConstraints columnConstraints = new ColumnConstraints(dimCasillero);
            columnConstraints.setFillWidth(true);
            this.mapa.getColumnConstraints().add(columnConstraints);
        }

        for(int fila = 0; fila <= cantidadFilas - 1; fila++){
            for(int columna = 0; columna <= cantidadColumnas - 1; columna++){
                // agrearCosas
            }
        }

        this.mapa.setGridLinesVisible(true);
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

    public void agregarUnidadAlMapa(Unidad posicionable, Parent vistaUnidad){

        for(Casillero casillero: posicionable.getPosicion().getListaCasilleros()){
            int x = casillero.getCoordenadaEnX();
            int y = casillero.getCoordenadaEnY();

            gridPaneRemove(this, x, y);
            this.mapa.add(vistaUnidad, x, y);
        }
    }
}
