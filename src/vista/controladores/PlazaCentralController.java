package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.IPosicionable;
import modelo.edificios.PlazaCentral;
import modelo.posicion.Posicion;

public class PlazaCentralController implements IPosicionableController {

    private PlazaCentral plazaCentral;
    private String color;

    public PlazaCentralController(PlazaCentral plazaCentral, String color){
        this.plazaCentral = plazaCentral;
        this.color = color;
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
        new Alert(Alert.AlertType.CONFIRMATION, "PlazaCentral!").show();
    }

}
