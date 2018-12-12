package vista.controladores.unidades;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.Unidad;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import vista.controladores.IJuegoController;
import vista.controladores.IPosicionableController;
import vista.controles.AldeanoBotonera;
import vista.controles.Botonera;
import vista.controles.MapaControl;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public abstract class UnidadController<TUnidad extends Unidad> implements IPosicionableController, Initializable {

    @FXML
    protected GridPane root;
    @FXML protected ImageView imageView;

//    Botonera botonera;
    abstract Botonera getBotonera();
    private String estado = "seleccionable";

    private IAtacante atacante;
    public void estadoAtaquePotencial(IAtacante atacante){
        this.atacante = atacante;
        this.estado = "ataquePotencial";
    }
    public void estadoSeleccionable(){
        this.estado = "seleccionable";
    }

    private TUnidad unidad;
    protected String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;

    public UnidadController(TUnidad unidad, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.unidad = unidad;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;

    }

    @Override
    public IPosicionable getPosicionable() {
        return this.unidad;
    }

    @Override
    public Posicion getPosicion() {
        return unidad.getPosicion();
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
                this.atacante.atacar(this.unidad);
                new Alert(Alert.AlertType.INFORMATION, "Ataque concretado").show();
                this.playSound();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String className = this.unidad.getClass().getSimpleName();
        String resource = String.format("/vista/css/%s.css", className);
        this.root.getStylesheets().add(this.getClass().getResource(resource).toExternalForm());
        this.imageView.getStyleClass().add(color);
    }


    abstract String getWavFile();

    private void playSound(){

        try
        {

            String f = String.format("/vista/sonidos/%s", this.getWavFile());
//            String file = "/vista/sonidos/recibir_ataque_asedio.wav";
            URL path = getClass().getResource(f);
            AudioClip ac = new AudioClip(path.toString());
            ac.play();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }



}
