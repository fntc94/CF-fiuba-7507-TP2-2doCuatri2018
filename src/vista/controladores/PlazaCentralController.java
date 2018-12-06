package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.edificios.PlazaCentral;
import modelo.posicion.Posicion;
import vista.controles.MapaControl;

public class PlazaCentralController implements IPosicionableController {

    private PlazaCentral plazaCentral;
    private String color;
    private MapaControl mapaControl;

    private String estado = "seleccionable";
    private IAtacante atacante;
    public void estadoAtaquePotencial(IAtacante atacante){
        this.atacante = atacante;
        this.estado = "ataquePotencial";
    }
    public void estadoSeleccionable(){
        this.estado = "seleccionable";
    }

    public PlazaCentralController(PlazaCentral plazaCentral, String color, MapaControl mapaControl){
        this.plazaCentral = plazaCentral;
        this.color = color;
        this.mapaControl = mapaControl;
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.plazaCentral;
    }

    @Override
    public Posicion getPosicion() {
        return plazaCentral.getPosicion();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void handleClick(MouseEvent mouseEvent) {

        if(this.estado.equals("seleccionable")){
            new Alert(Alert.AlertType.CONFIRMATION, "PlazaCentral seleccionada!").show();
        }
        if(this.estado.equals("ataquePotencial")){
            new Alert(Alert.AlertType.CONFIRMATION, "PlazaCentral atacada!").show();
            this.mapaControl.estadoSeleccionable();
        }
    }

}
