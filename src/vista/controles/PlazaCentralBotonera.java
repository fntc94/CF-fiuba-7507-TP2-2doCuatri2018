package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import modelo.edificios.PlazaCentral;
import modelo.unidades.Aldeano;
import vista.controladores.ConstruccionController;
import vista.controladores.MovimientoController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlazaCentralBotonera extends Botonera implements Initializable {

    @FXML
    private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private Label nombreLabel;
    private PlazaCentral plazaCentral;
    private double vidaInicial;

    public PlazaCentralBotonera(PlazaCentral plazaCentral, MapaControl mapa){

        super();
        this.plazaCentral = plazaCentral;
        this.vidaInicial = plazaCentral.getVida();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/PlazaCentralBotonera.fxml"));
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
        this.nombreLabel.setText(this.plazaCentral.getClass().getSimpleName());
    }

    private double obtenerProgresoDeVida(){
        return this.plazaCentral.getVida() / this.vidaInicial;
    }
    private void setVidaLabel(){
        String vidaInicial = String.valueOf((int)this.vidaInicial);
        String vidaActual = String.valueOf(this.plazaCentral.getVida());
        String texto = String.format("Vida: %s/%s", vidaActual, vidaInicial);

        this.vidaLabel.setText(texto);

    }

    public void actualizarUI(){
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());
        this.setVidaLabel();
    }

}
