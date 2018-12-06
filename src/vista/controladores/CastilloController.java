package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.edificios.Castillo;
import modelo.posicion.Posicion;
import vista.controles.MapaControl;

public class CastilloController implements IPosicionableController {

    private MapaControl mapaControl;

    private Castillo castillo;
    private String color;

    private String estado = "seleccionable";

    private IAtacante atacante;
    public void estadoAtaquePotencial(IAtacante atacante){
        this.atacante = atacante;
        this.estado = "ataquePotencial";
    }
    public void estadoSeleccionable(){
        this.estado = "seleccionable";
    }

    public CastilloController(Castillo castillo, String color, MapaControl mapaControl){
        this.castillo = castillo;
        this.color = color;
        this.mapaControl = mapaControl;
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.castillo;
    }

    @Override
    public Posicion getPosicion() {
        return castillo.getPosicion();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void handleClick(MouseEvent mouseEvent) {
        if(this.estado.equals("seleccionable")){
            new Alert(Alert.AlertType.CONFIRMATION, "Castillo seleccionado!").show();

        }
        if(this.estado.equals("ataquePotencial")){
            new Alert(Alert.AlertType.CONFIRMATION, "Castillo atacado!").show();
            this.mapaControl.estadoSeleccionable();
        }
    }


}
