package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.IPosicionable;
import modelo.edificios.Castillo;
import modelo.posicion.Posicion;

public class CastilloController implements IPosicionableController {

    private Castillo castillo;
    private String color;

    public CastilloController(Castillo castillo, String color){

        this.castillo = castillo;
        this.color = color;
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
        new Alert(Alert.AlertType.CONFIRMATION, "Castillo!").show();
    }

}
