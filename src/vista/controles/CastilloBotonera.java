package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import modelo.edificios.Castillo;
import modelo.edificios.PlazaCentral;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CastilloBotonera extends Botonera implements Initializable {

    @FXML
    private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private Label nombreLabel;
    Castillo castillo;
    private double vidaInicial;

    public CastilloBotonera(Castillo castillo, MapaControl mapa){

        super();
        this.castillo = castillo;
        this.vidaInicial = castillo.getVida();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/CastilloBotonera.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setVidaLabel();
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());
        this.nombreLabel.setText(this.castillo.getClass().getSimpleName());
    }

    private double obtenerProgresoDeVida(){
        return this.castillo.getVida() / this.vidaInicial;
    }
    private void setVidaLabel(){
        String vidaInicial = String.valueOf((int)this.vidaInicial);
        String vidaActual = String.valueOf(this.castillo.getVida());
        String texto = String.format("Vida: %s/%s", vidaActual, vidaInicial);

        this.vidaLabel.setText(texto);

    }

    public void actualizarUI(){
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());
        this.setVidaLabel();
    }

}
