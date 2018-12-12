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
import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;

import modelo.juego.Jugador;

import modelo.posicion.Casillero;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import modelo.unidades.*;
import vista.controladores.*;

import modelo.posicion.*;
import vista.controladores.edificios.CuartelControler;
import vista.controladores.edificios.PlazaCentralController;
import vista.controladores.unidades.AldeanoController;
import vista.controladores.unidades.ArmaDeAsedioController;
import vista.controladores.unidades.ArqueroController;
import vista.controladores.unidades.EspadachinController;

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

    private Object dragSource = null;

    public void setDragSource(Object object){
        this.dragSource = object;
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

        Dragboard db = event.getDragboard();

        Node node = event.getPickResult().getIntersectedNode();
        int columna = this.mapaGrandeGridPane.getColumnIndex(node);
        int fila = this.mapaGrandeGridPane.getRowIndex(node);



        String textoRecibidoConImagen = (String) db.getContent(DataFormat.PLAIN_TEXT);
        boolean success = false;


        IPosicionableController controller = null;
        if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "plaza") {
            int tamanioEdificio = 2;
            Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(columna, fila), tamanioEdificio);
            PlazaCentral plazaCentral = new PlazaCentral(posicion, new UnidadesFabrica());
            controller = new PlazaCentralController(plazaCentral, "red", this, this.juegoControl);
            success = true;

        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "cuartel"){
            int tamanioEdificio = 2;
            Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(columna, fila), tamanioEdificio);
            Cuartel cuartel = new Cuartel(posicion, new UnidadesFabrica());
            controller = new CuartelControler(cuartel, "red", this, this.juegoControl);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "Aldeano"){
            int tamanioEdificio = 1;
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            PlazaCentral plazaCentral = (PlazaCentral)this.dragSource;
            Aldeano aldeano = plazaCentral.construirAldeano(posicion);
            controller = new AldeanoController(aldeano, "red", this, this.juegoControl);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen.equals(Espadachin.class.getSimpleName())){
            int tamanioEdificio = 1;
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            Cuartel cuartel = (Cuartel)this.dragSource;
            Espadachin espadachin = cuartel.crearEspadachin(posicion);
            controller = new EspadachinController(espadachin, "red", this, this.juegoControl);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen.equals(Arquero.class.getSimpleName())){
            int tamanioEdificio = 1;
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            Cuartel cuartel = (Cuartel)this.dragSource;
            Arquero arquero = cuartel.crearArquero(posicion);
            controller = new ArqueroController(arquero, "red", this, this.juegoControl);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen.equals(ArmaDeAsedio.class.getSimpleName())){
            int tamanioEdificio = 1;
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            Castillo castillo = (Castillo)this.dragSource;
            ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio(posicion);
            controller = new ArmaDeAsedioController(armaDeAsedio, "red", this, this.juegoControl);
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
