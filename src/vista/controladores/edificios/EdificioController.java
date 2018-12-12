package vista.controladores.edificios;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import modelo.Edificio;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import vista.controladores.IJuegoController;
import vista.controladores.IPosicionableController;
import vista.controles.Botonera;
import vista.controles.MapaControl;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class EdificioController<TEdificio extends Edificio> implements IPosicionableController, Initializable {


    @FXML
    private GridPane root;
    @FXML private ImageView imageView;

//    private TBotonera botonera;
    private TEdificio edificio;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;

    private String estado = "seleccionable";
    private IAtacante atacante;
    public void estadoAtaquePotencial(IAtacante atacante){
        this.atacante = atacante;
        this.estado = "ataquePotencial";
    }
    public void estadoSeleccionable(){
        this.estado = "seleccionable";
    }

    public EdificioController(TEdificio edificio, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.edificio = edificio;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;

//        PlazaCentralBotonera plazaCentralBotonera = new PlazaCentralBotonera(plazaCentral, mapaControl);
//        this.botonera = plazaCentralBotonera;
    }

    abstract Botonera getBotonera();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String classSimpleName = this.edificio.getClass().getSimpleName();
        String resourcePath = String.format("/vista/css/%s.css", classSimpleName);
        this.root.getStylesheets().add(this.getClass().getResource(resourcePath).toExternalForm());
        this.imageView.getStyleClass().add(color);
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.edificio;
    }

    @Override
    public Posicion getPosicion() {
        return edificio.getPosicion();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void handleClick(MouseEvent mouseEvent) {

        if(this.estado.equals("seleccionable")){
            this.juegoController.setBotonera(this.getBotonera());
        }

        if(this.estado.equals("ataquePotencial")){

            try {
                this.atacante.atacar(this.edificio);
                new Alert(Alert.AlertType.INFORMATION, "Ataque concretado").show();
                this.getBotonera().actualizarUI();

            }
            catch (Exception e){
                new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
            }

            finally {
                this.mapaControl.estadoSeleccionable();
            }

        }
    }

}
