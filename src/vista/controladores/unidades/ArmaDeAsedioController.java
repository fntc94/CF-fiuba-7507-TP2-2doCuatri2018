package vista.controladores.unidades;

import modelo.unidades.ArmaDeAsedio;
import vista.controladores.IJuegoController;
import vista.controles.ArmaDeAsedioBotonera;
import vista.controles.Botonera;
import vista.controles.MapaControl;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmaDeAsedioController extends UnidadController<ArmaDeAsedio> {


    ArmaDeAsedioBotonera botonera;

    @Override
    Botonera getBotonera() {
        return this.botonera;
    }

    public ArmaDeAsedioController(ArmaDeAsedio armaDeAsedio, String color, MapaControl mapaControl, IJuegoController juegoController){
        super(armaDeAsedio, color, mapaControl, juegoController);

        this.botonera = new ArmaDeAsedioBotonera(armaDeAsedio, mapaControl, this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.root.getStylesheets().add(this.getClass().getResource("/vista/css/ArmaDeAsedio.css").toExternalForm());
        this.imageView.getStyleClass().add("red-desmontada");
    }

    @Override
    String getWavFile(){
        return "asedio.wav";
    }

//    @Override
//    protected void playSound(){
//
//        try
//        {
//
//            String file = "/vista/sonidos/asedio.wav";
//            URL path = getClass().getResource(file);
//            AudioClip ac = new AudioClip(path.toString());
//            ac.play();
//
//        }
//        catch (Exception e)
//        {
//            throw new RuntimeException(e);
//        }
//    }


    public void montar(){
        this.imageView.getStyleClass().clear();
        this.imageView.getStyleClass().add(String.format("%s-montada", this.color));
    }

    public void desmontar() {
        this.imageView.getStyleClass().clear();
        this.imageView.getStyleClass().add(String.format("%s-desmontada", this.color));
    }


}
