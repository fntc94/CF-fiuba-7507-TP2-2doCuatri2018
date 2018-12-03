package vista.controles;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import modelo.IMovible;
import modelo.IPosicionable;
import modelo.edificios.Castillo;
import modelo.edificios.PlazaCentral;
import modelo.juego.Jugador;
import modelo.posicion.Casillero;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import vista.controladores.AldeanoController;
import vista.controladores.PosicionableController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class MapaControl extends ScrollPane {

    private JuegoControl juegoControl;
    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;

    private Map<IPosicionable, Node> cosas = new HashMap();

    @FXML
    private GridPane gridPane;

    public MapaControl(JuegoControl juegoControl, Mapa mapa, Jugador jugador1, Jugador jugador2) {

        this.juegoControl = juegoControl;

        this.mapa = mapa;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Mapa.fxml"));
        loader.setRoot(this);
        loader.setController(this);


        try {
            loader.load();
            this.inicializarMapaVacio();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void dibujar() {

        try {
            for (IPosicionable posicionable : this.mapa) {
                this.dibujar(posicionable);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar(IPosicionable unidad) {

        Node nodo = this.cosas.get(unidad);
        this.gridPane.getChildren().remove(nodo);

        try{
            this.dibujar(unidad);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private void inicializarMapaVacio() {

        int cantidadFilas = this.mapa.getAlto();
        int cantidadColumnas = this.mapa.getAncho();
        int dimCasillero = 50;

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

    private void dibujar(IPosicionable posicionable) throws IOException {


        String color = this.obtenerColorPara(posicionable);

        Posicion posicion = posicionable.getPosicion();
        List<Casillero> casilleros = posicion.getListaCasilleros();
        Casillero abajoIzquierda = posicion.getAbajoIzquierda();


        String classSimpleName = posicionable.getClass().getSimpleName();
//            String fxml = String.format("/vista/vistas/%s.fxml", classSimpleName);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Posicionable.fxml"));

        loader.setControllerFactory(type -> {
            if (type.equals(PosicionableController.class)) {
                return new PosicionableController(this);
            } else {
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc); // fatal, just bail...
                }
            }
        });

        Parent vista = loader.load();

        PosicionableController controller = loader.getController();
        controller.setPosicionable(posicionable);
        controller.setJuego(this.juegoControl);

        String css = String.format("-fx-background-image: url(/vista/imagenes/%s%s.png)", classSimpleName, color);
        vista.setStyle(css);

        this.gridPane.add(vista, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

        GridPane.setColumnSpan(vista, posicion.getAncho());
        GridPane.setRowSpan(vista, posicion.getAlto());

        this.cosas.put(posicionable, vista);

    }

    private String obtenerColorPara(IPosicionable posicionable) {


        if (this.jugador1.esMio(posicionable)) {
            return "Rojo";
        }

        if (this.jugador2.esMio(posicionable)) {
            return "Azul";
        }

        throw new RuntimeException();
    }

    private void borrar(IPosicionable posicionable){

        Casillero casillero = posicionable.getPosicion().getAbajoIzquierda();
        int x = casillero.getCoordenadaEnX();
        int y = casillero.getCoordenadaEnY();

        this.gridPaneRemove(gridPane, x, y);
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {

            boolean colunOk = GridPane.getColumnIndex(node) == col;
            boolean rowOk = GridPane.getRowIndex(node) == row;

            if (colunOk && rowOk) {
                return node;
            }
        }
        return null;
    }

    private void gridPaneRemove(GridPane gridPane, int x, int y) {
        Node node = getNodeFromGridPane(gridPane, x, y);
        gridPane.getChildren().remove(node);
    }

}
