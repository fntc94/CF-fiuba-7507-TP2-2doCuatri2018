package controladores;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.Unidad;
import modelo.posicion.Casillero;

public class MapaController {

    private GridPane gridPane;

    public MapaController(GridPane mapa){
        this.gridPane = mapa;
    }

    public void llenarMapa() {

        int cantidadFilas = 20;
        int cantidadColumnas = 30;
        int dimCasillero = 50;

        for(int fila = 0; fila <= cantidadFilas - 1; fila++){
            RowConstraints rowConstraints = new RowConstraints(dimCasillero);
            rowConstraints.setFillHeight(true);
            this.gridPane.getRowConstraints().add(rowConstraints);
        }

        for(int columna = 0; columna <= cantidadColumnas - 1; columna++){
            ColumnConstraints columnConstraints = new ColumnConstraints(dimCasillero);
            columnConstraints.setFillWidth(true);
            this.gridPane.getColumnConstraints().add(columnConstraints);
        }

        for(int fila = 0; fila <= cantidadFilas - 1; fila++){
            for(int columna = 0; columna <= cantidadColumnas - 1; columna++){

            }
        }

        this.gridPane.setGridLinesVisible(true);
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children){

            boolean colunOk = gridPane.getColumnIndex(node) == col;
            boolean rowOk = gridPane.getRowIndex(node) == row;

            if (colunOk && rowOk){
                return node;
            }
        }
        return null;
    }

    private void gridPaneRemove(GridPane gridPane, int x, int y){
        Node node = getNodeFromGridPane(gridPane, x, y);
        gridPane.getChildren().remove(node);
    }

    public void agregarUnidadAlMapa(Unidad posicionable, Parent vistaUnidad){

        for(Casillero casillero: posicionable.getPosicion().getListaCasilleros()){
            int x = casillero.getCoordenadaEnX();
            int y = casillero.getCoordenadaEnY();

//            gridPaneRemove(this.gridPane, x, y);
            this.gridPane.add(vistaUnidad, x, y);
        }
    }
}
