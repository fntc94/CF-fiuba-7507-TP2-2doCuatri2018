package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.Edificio;
import modelo.IAtacante;

import modelo.IPosicionable;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;

import modelo.juego.Jugador;

import modelo.posicion.Casillero;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import vista.controladores.*;

import modelo.posicion.*;
import modelo.unidades.UnidadesFabrica;

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
    private MiniMapaController miniMapaController;

    private Map<IPosicionable, Node> vistas = new HashMap();
    private Map<IPosicionable, IPosicionableController> controladores = new HashMap();

    private Aldeano dragSource = null;

    public void setDragSource(Aldeano aldeano){
        this.dragSource = aldeano;
    }


    @FXML
    private GridPane mapaGrandeGridPane;

    public MapaControl(JuegoControl juegoControl, Mapa mapa, Jugador jugador1, Jugador jugador2, MiniMapaController miniMapaController) {

        this.juegoControl = juegoControl;
        this.mapa = mapa;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.miniMapaController = miniMapaController;


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


    private void inicializarMapaVacio() {

        int cantidadFilas = this.mapa.getAlto();
        int cantidadColumnas = this.mapa.getAncho();
        int dimCasillero = 50;

        for (int fila = 0; fila <= cantidadFilas - 1; fila++) {
            RowConstraints rowConstraints = new RowConstraints(dimCasillero);
            rowConstraints.setFillHeight(true);
            this.mapaGrandeGridPane.getRowConstraints().add(rowConstraints);
        }

        for (int columna = 0; columna <= cantidadColumnas - 1; columna++) {
            ColumnConstraints columnConstraints = new ColumnConstraints(dimCasillero);
            columnConstraints.setFillWidth(true);
            this.mapaGrandeGridPane.getColumnConstraints().add(columnConstraints);
        }

        for (int fila = 0; fila <= cantidadFilas - 1; fila++) {
            for (int columna = 0; columna <= cantidadColumnas - 1; columna++) {
                this.mapaGrandeGridPane.add(new AnchorPane(), columna, fila);
                // requerido para drag and drop;
            }
        }


        this.mapaGrandeGridPane.setGridLinesVisible(true);

    }

    public void agregar(IPosicionableController controlador){
        Posicion posicion = controlador.getPosicion();

        IPosicionable posicionable = controlador.getPosicionable();
        Node vista = this.crearVista(controlador);
        this.agregar(vista, posicion, posicionable);


        this.vistas.put(posicionable, vista);
        this.controladores.put(posicionable, controlador);

        this.miniMapaController.agregar(posicionable, controlador.getColor());
    }


    public void dibujar(){

        this.mapaGrandeGridPane.getChildren().removeAll(this.vistas.values());

        for(IPosicionable posicionable: this.mapa){
            try{
                this.dibujar(posicionable);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        this.miniMapaController.dibujar();

    }


    private Node crearVista(IPosicionableController controller){
        return new PosicionableVista(controller);
    }

    private void dibujar(IPosicionable posicionable) throws IOException {
        Posicion posicion = posicionable.getPosicion();

        IPosicionableController controller = this.controladores.get(posicionable);

        Node vista;
        if(this.vistas.containsKey(posicionable)){
           vista = this.vistas.get(posicionable);
        }
        else{
            vista = this.crearVista(controller);
        }
//        Node vista = this.crearVista(controller);

        this.agregar(vista, posicion, posicionable);
        this.vistas.put(posicionable, vista);

    }

    private void agregar(Node vista, Posicion posicion, IPosicionable posicionable){
        List<Casillero> casilleros = posicion.getListaCasilleros();
        Casillero abajoIzquierda = posicion.getAbajoIzquierda();


        try{
            this.mapa.posicionar(posicionable);
        }
        catch (Exception e){
            new Alert(Alert.AlertType.INFORMATION, "Posición ocupada");
        }

        this.mapaGrandeGridPane.add(vista, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

        GridPane.setColumnSpan(vista, posicion.getAncho());
        GridPane.setRowSpan(vista, posicion.getAlto());
    }

    public void estadoAtaque(IAtacante atacante) {

        for(IPosicionableController controller: this.controladores.values()){

            controller.estadoAtaquePotencial(atacante);

        }
    }


    public void estadoSeleccionable() {

        for(IPosicionableController controller: this.controladores.values()){
            controller.estadoSeleccionable();
        }
    }
    public void dragDropped(DragEvent event) throws IOException {

        Aldeano dragSource = this.dragSource;

        Dragboard db = event.getDragboard();

        Node node = event.getPickResult().getIntersectedNode();
        int columna = this.mapaGrandeGridPane.getColumnIndex(node);
        int fila = this.mapaGrandeGridPane.getRowIndex(node);
        int tamanioEdificio = 2;


        String textoRecibidoConImagen = (String) db.getContent(DataFormat.PLAIN_TEXT);
        boolean success = false;
        Posicion posicionEdificioEnContruccion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(columna, fila), tamanioEdificio);

        IPosicionable edificio;
        IPosicionableController controller = null;
        if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "plaza") {
            edificio = new PlazaCentral(posicionEdificioEnContruccion, new UnidadesFabrica());
            controller = new EdificioEnConstruccionController(edificio, "PlazaCentral", "red");
            success = true;

        }else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "cuartel"){
            edificio = new Cuartel(posicionEdificioEnContruccion, new UnidadesFabrica());
            controller = new EdificioEnConstruccionController(edificio, "Cuartel", "red");
            success = true;
        }

        this.agregar(controller);
        /* let the source know whether the string was successfully
         * transferred and used */
        event.setDropCompleted(success);

        event.consume();

        this.dragSource = null;
    }

    public void dragOver(DragEvent event){
        if(event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

}
