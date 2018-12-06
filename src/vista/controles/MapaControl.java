package vista.controles;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.IPosicionable;
import modelo.juego.Jugador;
import modelo.posicion.Casillero;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import vista.PosicionableControllerFactory;
import vista.controladores.IPosicionableController;
import vista.controladores.MiniMapaController;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Posicionable.fxml"));
        loader.setController(controller);

        Parent vista = null;
        try {
            vista = loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        String color = controller.getColor();
        String classSimpleName = controller.getPosicionable().getClass().getSimpleName();
        String css = String.format("-fx-background-image: url(/vista/imagenes/%s_%s.png)", classSimpleName, color);
        vista.setStyle(css);


        return vista;
    }

    private void dibujar(IPosicionable posicionable) throws IOException {
        Posicion posicion = posicionable.getPosicion();

        IPosicionableController controller = this.controladores.get(posicionable);
        Node vista = this.crearVista(controller);

        this.agregar(vista, posicion, posicionable);
        this.vistas.put(posicionable, vista);

    }

    private void agregar(Node vista, Posicion posicion, IPosicionable posicionable){
        List<Casillero> casilleros = posicion.getListaCasilleros();
        Casillero abajoIzquierda = posicion.getAbajoIzquierda();

        this.mapaGrandeGridPane.add(vista, abajoIzquierda.getCoordenadaEnX(), abajoIzquierda.getCoordenadaEnY());

        GridPane.setColumnSpan(vista, posicion.getAncho());
        GridPane.setRowSpan(vista, posicion.getAlto());
    }

}
