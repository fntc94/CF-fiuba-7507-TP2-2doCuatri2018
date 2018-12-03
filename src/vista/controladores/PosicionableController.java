package vista.controladores;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.IPosicionable;
import modelo.unidades.Aldeano;
import vista.controles.AldeanoBotonera;
import vista.controles.JuegoControl;
import vista.controles.MapaControl;

public class PosicionableController {

    private IPosicionable posicionable;
    private JuegoControl juegoControl;
    private MapaControl mapaControl;

    public PosicionableController(MapaControl mapaControl){
        this.mapaControl = mapaControl;
    }

    public void handleClick(MouseEvent mouseEvent) {

        String className = posicionable.getClass().getSimpleName();


        if(className.equals(Aldeano.class.getSimpleName())){

            Aldeano aldeano = (Aldeano) this.posicionable;
            AldeanoBotonera botonera = new AldeanoBotonera(aldeano, mapaControl);
            juegoControl.setBotonera(botonera);

        }

        else{
            new Alert(Alert.AlertType.CONFIRMATION, className).show();
        }

    }

    public void setPosicionable(IPosicionable posicionable){
        this.posicionable = posicionable;
    }

    public void setJuego(JuegoControl juegoControl){

        this.juegoControl = juegoControl;
    }

}
