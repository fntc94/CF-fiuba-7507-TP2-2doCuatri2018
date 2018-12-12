package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CuartelBotonera extends Botonera implements Initializable {

    @FXML
    private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private Label nombreLabel;
    private Cuartel cuartel;
    private double vidaInicial;

    public CuartelBotonera(Cuartel cuartel, MapaControl mapa){

        super();
        this.cuartel = cuartel;
        this.vidaInicial = cuartel.getVida();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/CuartelBotonera.fxml"));
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
        this.nombreLabel.setText(this.cuartel.getClass().getSimpleName());
    }

    private double obtenerProgresoDeVida(){
        return this.cuartel.getVida() / this.vidaInicial;
    }
    private void setVidaLabel(){
        String vidaInicial = String.valueOf((int)this.vidaInicial);
        String vidaActual = String.valueOf(this.cuartel.getVida());
        String texto = String.format("Vida: %s/%s", vidaActual, vidaInicial);

        this.vidaLabel.setText(texto);

    }

    public void actualizarUI(){
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());
        this.setVidaLabel();
    }

}
