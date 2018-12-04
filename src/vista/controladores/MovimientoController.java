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
    private void handleIzquierdaArriba(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.izquierdaArriba());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleArriba(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.arriba());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleDerechaArriba(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.derechaArriba());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleIzquierda(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.izquierda());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleDerecha(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.derecha());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleIzquierdaAbajo(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.izquierdaAbajo());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleAbajo(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.abajo());
        this.mapa.actualizar(this.unidad);
    }

    @FXML
    private void handleDerechaAbajo(MouseEvent mouseEvent) {
        this.unidad.mover(Direccion.derechaAbajo());
        this.mapa.actualizar(this.unidad);
    }

}
