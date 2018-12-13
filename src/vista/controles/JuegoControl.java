package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.IPosicionable;
import modelo.edificios.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.juego.Turno;
import modelo.posicion.*;
import modelo.unidades.*;
import vista.controladores.PosicionableControllerFactory;
import javafx.scene.control.Button;
import vista.controladores.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class JuegoControl extends BorderPane implements Initializable, IJuegoController {


    public static JuegoControl instanacia;

    public static void Inicializar(Stage primaryStage, String jugador1, String jugador2){
        if(instanacia != null){
            throw new RuntimeException();
        }
        instanacia = new JuegoControl(primaryStage, jugador1, jugador2);
    }

    public static JuegoControl getInstanacia(){

        if(instanacia == null){
            throw new RuntimeException();
        }
        return instanacia;
    }

    private Stage primaryStage;
    private Juego juego;
    private List<Jugador> listaDeParticipantes;
    private MapaControl mapaControl;
    private Turno turno;
    private MenuController menuController;

    @FXML
    private GridPane botonera;
    @FXML
    private Button pasarTurno;
    @FXML
    private Text fichaTecnica;

    private Jugador jugador1;
    private Jugador jugador2;

    private Map<Jugador, String> colores = new HashMap();

    JuegoControl(Stage primaryStage, String nombreJugador1, String nombreJugador2) {
        this.listaDeParticipantes = new ArrayList();

        this.primaryStage = primaryStage;

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        this.juego = juego;
        MiniMapaController miniMapaController = new MiniMapaController(this, juego.getMapa());
        MapaControl mapaControl = new MapaControl(this, juego.getMapa(), juego.getJugador1(), juego.getJugador2(), miniMapaController);
        this.mapaControl = mapaControl;

        MenuController menuController = new MenuController();
        this.menuController = menuController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Juego.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        loader.setControllerFactory(type -> {

            if(type.equals(MenuController.class)){
                return menuController;
            }

            if (type.equals(MiniMapaController.class)) {
                return miniMapaController;
            }

            else {
                // default behavior for controllerFactory:
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc);
                }
            }
        });


        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        this.inicializarJugador1(nombreJugador1);
        this.inicializarJugador2(nombreJugador2);

        this.turno = new Turno(this.listaDeParticipantes);
        this.fichaTecnica.setText(this.turno.devolverJugadorActual().devolverNombre());

        this.centerProperty().setValue(mapaControl);
        this.autosize();

        menuController.init();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void setBotonera(Node node) {
        this.botonera.getChildren().clear();
        this.botonera.add(node, 1, 0);
    }

    public  void cleanBotonera(){
        this.botonera.getChildren().clear();
    }

    private void inicializarJugador1(String nombreJugador){
        Mapa mapa = this.juego.getMapa();
        Posicion posicionCastillo = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(0,0), 3);
        Posicion posicionPlazaCentral = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(3,3), 2);
        Posicion posicionAldeano1 = new PosicionDeUnCasillero(mapa,5,1);
        Posicion posicionAldeano2 = new PosicionDeUnCasillero(mapa,1,5);
        Posicion posicionAldeano3 = new PosicionDeUnCasillero(mapa,5,5);

        Castillo castillo = new Castillo(posicionCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());
        PlazaCentral plazaCentral = new PlazaCentral(posicionPlazaCentral, new UnidadesFabrica());
        Aldeano aldeano1 = new Aldeano(posicionAldeano1);
        Aldeano aldeano2 = new Aldeano(posicionAldeano2);
        Aldeano aldeano3 = new Aldeano(posicionAldeano3);


        Jugador jugador = new Jugador(nombreJugador, castillo);
        this.jugador1 = jugador;
        this.colores.put(jugador, "red");
        jugador.agregar(plazaCentral);
        jugador.agregar(aldeano1);
        jugador.agregar(aldeano2);
        jugador.agregar(aldeano3);

        this.listaDeParticipantes.add(jugador);

        VistaFactory vistaFactory = new VistaFactory(this, this.mapaControl, "red");
        this.mapaControl.agregar(vistaFactory.crearVista(castillo));
        this.mapaControl.agregar(vistaFactory.crearVista(plazaCentral));
        this.mapaControl.agregar(vistaFactory.crearVista(aldeano1));
        this.mapaControl.agregar(vistaFactory.crearVista(aldeano2));
        this.mapaControl.agregar(vistaFactory.crearVista(aldeano3));

    }

    private void inicializarJugador2(String nombreJugador2){
        Mapa mapa = this.juego.getMapa();
        int ancho = mapa.getAncho();
        int alto = mapa.getAlto();

        Posicion posCastillo = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(mapa.getAncho() - 3, mapa.getAlto() - 3), 3);
        Posicion posPlazaCentral = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(mapa.getAncho() - 5, mapa.getAlto() - 5), 2);
        Posicion posAldeano1 =  new PosicionDeUnCasillero(mapa, ancho - 6, alto - 2);
        Posicion posAldeano2 = new PosicionDeUnCasillero(mapa, ancho -2, alto - 6);
        Posicion posAldeano3 = new PosicionDeUnCasillero(mapa, ancho - 6, alto -6);

        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());
        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        Jugador jugador = new Jugador(nombreJugador2, castillo);
        this.jugador2 = jugador;
        this.colores.put(jugador, "blue");
        jugador.agregar(plazaCentral);
        jugador.agregar(aldeano1);
        jugador.agregar(aldeano2);
        jugador.agregar(aldeano3);

        this.listaDeParticipantes.add(jugador);

        VistaFactory vistaFactory = new VistaFactory(this, this.mapaControl, "blue");
        this.mapaControl.agregar(vistaFactory.crearVista(castillo));
        this.mapaControl.agregar(vistaFactory.crearVista(plazaCentral));
        this.mapaControl.agregar(vistaFactory.crearVista(aldeano1));
        this.mapaControl.agregar(vistaFactory.crearVista(aldeano2));
        this.mapaControl.agregar(vistaFactory.crearVista(aldeano3));

    }


    public void cambioDeTurno(){
        this.turno.cambiarDeTurno();

        // Actualiza la barra donde aparece la cantidad de oro y poblacion
        this.menuController.actualizarEstadistica(this.getJugadorActual(), this.colores.get(this.getJugadorActual()));

        this.fichaTecnica.setText(this.turno.devolverJugadorActual().devolverNombre());
        this.cleanBotonera();

    }


    public boolean esDelJugador(IPosicionable posicionable){
        return (this.turno.devolverJugadorActual().esDuenoDe(posicionable));
    }

    public Jugador getJugadorActual(){
        return this.turno.devolverJugadorActual();
    }

    public String getColorJugadorActual(){
       return this.colores.get(this.getJugadorActual());
    }
}
