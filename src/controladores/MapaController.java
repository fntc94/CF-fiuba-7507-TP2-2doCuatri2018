package controladores;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import modelo.IPosicionable;
import modelo.Unidad;
import modelo.edificios.Castillo;
import modelo.edificios.EstrategiaAtaqueCastillo;
import modelo.edificios.PlazaCentral;
import modelo.juego.Juego;
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
    private Juego juego;

    public MapaController(){

        int altoMapa = 20;
        int anchoMapa = 30;
        Mapa mapa = new Mapa(altoMapa, anchoMapa);

        Juego juego = new Juego("J1", "J2");
        this.juego = juego;

        this.modeloMapa = juego.getMapa();
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


            String color = "";
            if(juego.getJugador1().esMio(posicionable)){
                color = "Rojo";
            }
            if(juego.getJugador2().esMio(posicionable)){
                color = "Azul";
            }

            Posicion posicion = posicionable.getPosicion();
            List<Casillero> casilleros = posicion.getListaCasilleros();
            Casillero abajoIzquierda = posicion.getAbajoIzquierda();

            if(posicionable.getClass() == Castillo.class){


                FXMLLoader castilloLoader = new FXMLLoader(getClass().getResource("/vistas/Castillo.fxml"));
                Parent vista = castilloLoader.load();

                String css = String.format("-fx-background-image: url(/vistas/imagenes/castillo%s.png)", color);
                vista.setStyle(css);

                this.mapa.add(vista, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

                GridPane.setColumnSpan(vista, posicion.getAncho());
                GridPane.setRowSpan(vista, posicion.getAlto());
            }

            if(posicionable.getClass() == PlazaCentral.class){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/PlazaCentral.fxml"));
                Parent vista = loader.load();
                this.mapa.add(vista, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

                String css = String.format("-fx-background-image: url(/vistas/imagenes/plazaCentral%s.png)", color);
                vista.setStyle(css);

                GridPane.setColumnSpan(vista, posicion.getAncho());
                GridPane.setRowSpan(vista, posicion.getAlto());
            }

            if(posicionable.getClass() == Aldeano.class){
                FXMLLoader aldeanoLoader = new FXMLLoader(getClass().getResource("/vistas/AldeanoView.fxml"));
                Parent vistaAldeano = aldeanoLoader.load();
                this.mapa.add(vistaAldeano, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

                String css = String.format("-fx-background-image: url(/vistas/imagenes/aldeano%s.png)", color);
                vistaAldeano.setStyle(css);
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
