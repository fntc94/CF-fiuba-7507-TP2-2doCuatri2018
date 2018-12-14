package vista.controles.botoneras.unidades;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.unidades.ArmaDeAsedio;
import vista.controladores.unidades.ArmaDeAsedioController;
import vista.controles.MapaControl;
import vista.utilidades.ReproductorDeSonido;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmaDeAsedioBotonera extends UnidadBotonera<ArmaDeAsedio> {

    private final MapaControl mapa;
    private ArmaDeAsedioController controller;


    @FXML private VBox botones;
    @FXML private Button buttonAtacar;
    @FXML private Button buttonMontar;
    @FXML private Button buttonDesmontar;
    @FXML private Button buttonCancelar;

    private Boolean montada = false;

    public ArmaDeAsedioBotonera(ArmaDeAsedio armaDeAsedio, MapaControl mapa, ArmaDeAsedioController controller){

        super(armaDeAsedio, mapa);
        this.mapa = mapa;
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        this.buttonDesmontar.setDisable(true);
        this.buttonAtacar.setDisable(true);
    }


    public void handleAtaque(){
        mapa.estadoAtaque(this.unidad);
        new ReproductorDeSonido("ataque_arma_asedio.wav").reproducirSonido();
        this.deshabilitar();

    }


    public void handleCancelar(){
        mapa.estadoSeleccionable();
    }

    public void handleMontar(){
        this.unidad.montar();
        this.montada = true;


        this.buttonMontar.setDisable(true);
        this.buttonDesmontar.setDisable(false);
        this.buttonAtacar.setDisable(false);

        this.controller.montar();
        this.deshabilitar();
    }

    public void handleDesmontar(){
        this.unidad.desmontar();
        this.montada = false;

        this.buttonMontar.setDisable(false);
        this.buttonDesmontar.setDisable(true);
        this.buttonAtacar.setDisable(true);

        controller.desmontar();
        this.deshabilitar();
    }

    @Override
    public void habilitar(){
       super.habilitar();
       this.buttonAtacar.setDisable(false);
       this.buttonMontar.setDisable(false);
       this.buttonDesmontar.setDisable(false);
       this.buttonCancelar.setDisable(false);

       if(this.montada){
           this.buttonMontar.setDisable(true);
           this.movimientoController.deshabilitar();
       }
       else{
           this.buttonDesmontar.setDisable(true);
       }
    }

    @Override
    public void deshabilitar(){
        super.deshabilitar();
        this.buttonAtacar.setDisable(true);
        this.buttonMontar.setDisable(true);
        this.buttonDesmontar.setDisable(true);
        this.buttonCancelar.setDisable(true);
    }

    @Override
    protected FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/vista/vistas/unidades/ArmaDeAsedioBotonera.fxml"));
    }
}
