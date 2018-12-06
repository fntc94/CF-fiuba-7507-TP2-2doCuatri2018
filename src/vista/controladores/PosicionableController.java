package vista.controladores;

import javafx.scene.input.MouseEvent;
import modelo.IPosicionable;
import modelo.posicion.Posicion;

public class PosicionableController implements IPosicionableController {

    private IPosicionable posicionable;
    private String color;

    public PosicionableController(IPosicionable posicionable, String color){

        this.posicionable = posicionable;
        this.color = color;
    }


    @Override
    public IPosicionable getPosicionable() {
        return posicionable;
    }

    @Override
    public Posicion getPosicion() {
        return posicionable.getPosicion();
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void handleClick(MouseEvent mouseEvent) {

    }
}
