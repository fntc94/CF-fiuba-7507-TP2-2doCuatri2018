package controladores;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.IPosicionable;
import modelo.Unidad;
import modelo.edificios.Castillo;
import modelo.edificios.EstrategiaAtaqueCastillo;
import modelo.edificios.PlazaCentral;
import modelo.posicion.*;
import modelo.unidades.Aldeano;
import modelo.unidades.UnidadesFabrica;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MapaController implements Initializable {

    @FXML
    private GridPane mapa;

    private Mapa modeloMapa;

    public MapaController(){

        int altoMapa = 20;
        int anchoMapa = 30;
        Mapa mapa = new Mapa(altoMapa, anchoMapa);

        PosicionCuadrado posicionCastillo = new PosicionCuadrado(1,3,1,3);
        Castillo castillo = new Castillo(posicionCastillo, new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posicionAldeano = new PosicionDeUnCasillero(0,0);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        mapa.posicionar(castillo);
        mapa.posicionar(aldeano);

        this.modeloMapa = mapa;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.inicializarMapa();

        try {
            this.llenarMapa();
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }


    private void llenarMapa() throws IOException {

        for(IPosicionable posicionable: this.modeloMapa){

            Posicion posicion = posicionable.getPosicion();
            List<Casillero> casilleros = posicion.getListaCasilleros();
            Casillero abajoIzquierda = posicion.getAbajoIzquierda();

            if(posicionable.getClass() == Castillo.class){

                FXMLLoader castilloLoader = new FXMLLoader(getClass().getResource("/vistas/Castillo.fxml"));
                Parent vistaCastillo = castilloLoader.load();
                this.mapa.add(vistaCastillo, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

                GridPane.setColumnSpan(vistaCastillo, 3);
                GridPane.setRowSpan(vistaCastillo, 3);
            }

            if(posicionable.getClass() == Aldeano.class){
                FXMLLoader aldeanoLoader = new FXMLLoader(getClass().getResource("/vistas/AldeanoView.fxml"));
                Parent vistaAldeano = aldeanoLoader.load();
                this.mapa.add(vistaAldeano, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());
            }

        }

    }

    public void agregarUnidadAlMapa(Unidad posicionable, Parent vistaUnidad){

        for(Casillero casillero: posicionable.getPosicion().getListaCasilleros()){
            int x = casillero.getCoordenadaEnX();
            int y = casillero.getCoordenadaEnY();

//            gridPaneRemove(this.mapa, x, y);
            this.mapa.add(vistaUnidad, x - 1 , y - 1);
        }
    }

    public void inicializarMapa() {

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

            }
        }

        this.mapa.setGridLinesVisible(true);
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




}
