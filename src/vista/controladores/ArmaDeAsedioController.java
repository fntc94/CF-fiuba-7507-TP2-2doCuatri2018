package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Arquero;
import vista.controles.ArmaDeAsedioBotonera;
import vista.controles.ArqueroBotonera;
import vista.controles.MapaControl;

public class ArmaDeAsedioController implements IPosicionableController {

    private final ArmaDeAsedioBotonera botonera;
    private ArmaDeAsedio armaDeAsedio;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;
    private IAtacante atacante;

    private String estado = "seleccionable";

    public ArmaDeAsedioController(ArmaDeAsedio armaDeAsedio, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.armaDeAsedio = armaDeAsedio;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;


        this.botonera = new ArmaDeAsedioBotonera(armaDeAsedio, mapaControl);
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.armaDeAsedio;
    }

    @Override
    public Posicion getPosicion() {
        return armaDeAsedio.getPosicion();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void handleClick(MouseEvent mouseEvent) {
        if(this.estado.equals("seleccionable")){
            this.juegoController.setBotonera(botonera);
        }

        if(this.estado.equals("ataquePotencial")){

            try {
                this.atacante.atacar(this.armaDeAsedio);
                new Alert(Alert.AlertType.INFORMATION, "Ataque concretado").show();
                this.botonera.actualizarUI();
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
    public void estadoAtaquePotencial(IAtacante atacante) {
        this.estado = "ataquePotencial";
        this.atacante = atacante;
    }

    public void estadoSeleccionable(){
        this.estado = "seleccionable";
    }
}
