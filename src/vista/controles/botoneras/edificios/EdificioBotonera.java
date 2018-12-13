package vista.controles.botoneras.edificios;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import modelo.Edificio;
import vista.controles.MapaControl;
import vista.controles.botoneras.Botonera;
import vista.controles.botoneras.VidaController;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class EdificioBotonera<TEdificio extends Edificio> extends Botonera implements Initializable {


    @FXML private Label nombreLabel;
    TEdificio edificio;
    protected MapaControl mapa;

    protected VidaController vidaController;

    protected abstract FXMLLoader getLoader();

    public EdificioBotonera(TEdificio edificio, MapaControl mapa){

        super();
        this.edificio = edificio;
        this.mapa = mapa;

        FXMLLoader loader = this.getLoader();
        loader.setRoot(this);

        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nombreLabel.setText(this.edificio.getClass().getSimpleName());
        this.vidaController.actualizarUI();
    }

    public void actualizarUI(){
        this.vidaController.actualizarUI();
    }

}
