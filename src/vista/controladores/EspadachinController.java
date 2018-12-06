package vista.controladores;

import com.sun.scenario.effect.impl.state.RenderState;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.Espadachin;
import vista.controles.EspadachinBotonera;
import vista.controles.MapaControl;

public class EspadachinController implements IPosicionableController {

    private final EspadachinBotonera botonera;
    private Espadachin espadachin;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;
    private IAtacante atacante;

    private String estado = "seleccionable";

    public EspadachinController(Espadachin espadachin, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.espadachin = espadachin;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;


        this.botonera = new EspadachinBotonera(espadachin, mapaControl);
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.espadachin;
    }

    @Override
    public Posicion getPosicion() {
        return espadachin.getPosicion();
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
                this.atacante.atacar(this.espadachin);
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
