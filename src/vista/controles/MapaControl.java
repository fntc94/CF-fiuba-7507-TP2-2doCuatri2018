package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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

import java.io.IOException;
import java.util.*;

@SuppressWarnings("ALL")
public class MapaControl extends ScrollPane {

    private JuegoControl juegoControl;
    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;
    private MiniMapaController miniMapaController;
    private MenuController menuController;

    private Object dragSource = null;

    public void setDragSource(Object object){
        this.dragSource = object;
    }



    public Collection<PosicionableVista> vistas = new ArrayList<>();


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

    private void dibujarEnMapa(PosicionableVista vista){
        IPosicionableController controlador = vista.getController();
        Posicion posicion = controlador.getPosicion();
        IPosicionable posicionable = controlador.getPosicionable();

        List<Casillero> casilleros = posicion.getListaCasilleros();
        Casillero abajoIzquierda = posicion.getAbajoIzquierda();
        int columna = abajoIzquierda.getCoordenadaEnX();
        int fila = abajoIzquierda.getCoordenadaEnY();

        this.mapaGrandeGridPane.add(vista, columna, fila);
        GridPane.setColumnSpan(vista, posicion.getAncho());
        GridPane.setRowSpan(vista, posicion.getAlto());

    }

    public void agregar(PosicionableVista vista){
        this.dibujarEnMapa(vista);
        this.vistas.add(vista);
        this.mapa.posicionar(vista.getController().getPosicionable());
        this.miniMapaController.agregar(vista);
        this.miniMapaController.dibujar();
    }

    public void dibujar(){

        this.mapaGrandeGridPane.getChildren().removeAll(this.vistas);

        for(PosicionableVista vista: this.vistas){
            this.dibujarEnMapa(vista);
        }


        this.miniMapaController.dibujar();

    }

    public void remover(PosicionableVista vista){
        this.juegoControl.recolectarCadaveresDeAmbosJugadores();

        this.mapaGrandeGridPane.getChildren().remove(vista);
        this.vistas.remove(vista);
        IPosicionable posicionable = vista.getController().getPosicionable();
        this.mapa.remover(posicionable);
        this.dibujar();

        this.miniMapaController.remover(vista);
        this.miniMapaController.dibujar();
    }

    public void estadoAtaque(IAtacante atacante) {

        for(PosicionableVista vista: this.vistas){
            IPosicionableController controller = vista.getController();
            controller.estadoAtaquePotencial(atacante);
        }
    }

    public void habilitarControladores(){
        for(PosicionableVista vista: this.vistas){
            IPosicionableController controller = vista.getController();
            controller.habilitar();
        }
    }



    public void estadoSeleccionable() {

        for(PosicionableVista vista: this.vistas){
            IPosicionableController controller = vista.getController();
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
            String color = JuegoControl.getInstanacia().getColorJugadorActual();
            Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(columna, fila), tamanioEdificio);
            PlazaCentral plazaCentral = new PlazaCentral(posicion, new UnidadesFabrica());
            this.agregar(new VistaFactory(this.juegoControl, this, color).crearVista(plazaCentral));
            JuegoControl.getInstanacia().getJugadorActual().agregar(plazaCentral);
            success = true;

        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "cuartel"){
            int tamanioEdificio = 2;
            String color = JuegoControl.getInstanacia().getColorJugadorActual();
            Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(columna, fila), tamanioEdificio);
            Cuartel cuartel = new Cuartel(posicion, new UnidadesFabrica());
            this.agregar(new VistaFactory(this.juegoControl, this, color).crearVista(cuartel));
            JuegoControl.getInstanacia().getJugadorActual().agregar(cuartel);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen == "Aldeano"){
            int tamanioEdificio = 1;
            String color = JuegoControl.getInstanacia().getColorJugadorActual();
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            PlazaCentral plazaCentral = (PlazaCentral)this.dragSource;
            Aldeano aldeano = plazaCentral.construirAldeano(posicion);
            this.agregar(new VistaFactory(this.juegoControl, this, color).crearVista(aldeano));
            JuegoControl.getInstanacia().getJugadorActual().agregar(aldeano);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen.equals(Espadachin.class.getSimpleName())){
            int tamanioEdificio = 1;
            String color = JuegoControl.getInstanacia().getColorJugadorActual();
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            Cuartel cuartel = (Cuartel)this.dragSource;
            Espadachin espadachin = cuartel.crearEspadachin(posicion);
            this.agregar(new VistaFactory(this.juegoControl, this, color).crearVista(espadachin));
            JuegoControl.getInstanacia().getJugadorActual().agregar(espadachin);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen.equals(Arquero.class.getSimpleName())){
            int tamanioEdificio = 1;
            String color = JuegoControl.getInstanacia().getColorJugadorActual();
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            Cuartel cuartel = (Cuartel)this.dragSource;
            Arquero arquero = cuartel.crearArquero(posicion);
            this.agregar(new VistaFactory(this.juegoControl, this, color).crearVista(arquero));
            JuegoControl.getInstanacia().getJugadorActual().agregar(arquero);
            success = true;
        }

        else if (db.hasContent(DataFormat.PLAIN_TEXT) && textoRecibidoConImagen.equals(ArmaDeAsedio.class.getSimpleName())){
            int tamanioEdificio = 1;
            String color = JuegoControl.getInstanacia().getColorJugadorActual();
            Posicion posicion = new PosicionDeUnCasillero(this.mapa, columna, fila);
            Castillo castillo = (Castillo)this.dragSource;
            ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio(posicion);
            this.agregar(new VistaFactory(this.juegoControl, this, color).crearVista(armaDeAsedio));
            JuegoControl.getInstanacia().getJugadorActual().agregar(armaDeAsedio);
            success = true;
        }


        this.menuController.actualizarPoblacion(this.juegoControl.getJugadorActual().cantidadDePoblacion(), this.juegoControl.getColorJugadorActual());

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

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
