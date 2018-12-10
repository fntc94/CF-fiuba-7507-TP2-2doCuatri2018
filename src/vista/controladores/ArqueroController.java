package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import vista.controles.ArqueroBotonera;
import vista.controles.EspadachinBotonera;
import vista.controles.MapaControl;

public class ArqueroController implements IPosicionableController {

    private final ArqueroBotonera botonera;
    private Arquero arquero;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;
    private IAtacante atacante;

    private String estado = "seleccionable";

    public ArqueroController(Arquero arquero, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.arquero = arquero;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;


        this.botonera = new ArqueroBotonera(arquero, mapaControl);
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.arquero;
    }

    @Override
    public Posicion getPosicion() {
        return arquero.getPosicion();
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
                this.atacante.atacar(this.arquero);
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
