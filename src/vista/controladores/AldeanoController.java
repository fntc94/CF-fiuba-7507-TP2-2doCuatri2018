package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import vista.controles.AldeanoBotonera;
import vista.controles.MapaControl;


public class AldeanoController implements IPosicionableController {


    AldeanoBotonera botonera;
    private String estado = "seleccionable";

    private IAtacante atacante;
    public void estadoAtaquePotencial(IAtacante atacante){
        this.atacante = atacante;
        this.estado = "ataquePotencial";
    }
    public void estadoSeleccionable(){
        this.estado = "seleccionable";
    }

    private Aldeano aldeano;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;

    public AldeanoController(Aldeano aldeano, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.aldeano = aldeano;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;

        AldeanoBotonera botonera = new AldeanoBotonera(aldeano, mapaControl);
        this.botonera = botonera;
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.aldeano;
    }

    @Override
    public Posicion getPosicion() {
        return aldeano.getPosicion();
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
               this.atacante.atacar(this.aldeano);
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

}
