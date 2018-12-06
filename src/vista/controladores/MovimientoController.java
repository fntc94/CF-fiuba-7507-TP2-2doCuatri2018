package vista.controladores;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import modelo.IMovible;
import modelo.movimiento.*;
import vista.controles.MapaControl;

public class MovimientoController {


    private MapaControl mapa;
    private IMovible unidad;

    public MovimientoController(IMovible unidad, MapaControl mapa){
        this.mapa = mapa;
        this.unidad = unidad;
    }

    @FXML
    private void handleIzquierdaArriba() {
        this.unidad.mover(Direccion.izquierdaArriba());
        this.mapa.dibujar();
    }

    @FXML
    private void handleArriba() {
        this.unidad.mover(Direccion.arriba());
        this.mapa.dibujar();
    }

    @FXML
    private void handleDerechaArriba() {
        this.unidad.mover(Direccion.derechaArriba());
        this.mapa.dibujar();
    }

    @FXML
    private void handleIzquierda() {
        this.unidad.mover(Direccion.izquierda());
        this.mapa.dibujar();
    }

    @FXML
    private void handleDerecha() {
        this.unidad.mover(Direccion.derecha());
        this.mapa.dibujar();
    }

    @FXML
    private void handleIzquierdaAbajo() {
        this.unidad.mover(Direccion.izquierdaAbajo());
        this.mapa.dibujar();
    }

    @FXML
    private void handleAbajo() {
        this.unidad.mover(Direccion.abajo());
        this.mapa.dibujar();
    }

    @FXML
    private void handleDerechaAbajo() {
        this.unidad.mover(Direccion.derechaAbajo());
        this.mapa.dibujar();
    }

}
