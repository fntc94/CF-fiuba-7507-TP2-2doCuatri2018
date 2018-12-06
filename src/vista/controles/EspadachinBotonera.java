package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import modelo.unidades.Aldeano;
import modelo.unidades.Espadachin;
import vista.controladores.IPosicionController;
import vista.controladores.MovimientoController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EspadachinBotonera extends GridPane implements Initializable {

    private final Espadachin espadachin;
    private double vidaInicial;

    @FXML private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private Label nombreLabel;

    public EspadachinBotonera(Espadachin espadachin, MapaControl mapa){

        super();
        this.espadachin = espadachin;
        this.vidaInicial = espadachin.getVida();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/EspadachinBotonera.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        loader.setControllerFactory(type -> {

            if(type.equals(MovimientoController.class)){
                return new MovimientoController(espadachin, mapa);
            }

            else {
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc);
                }
            }

        });


        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String vida = String.valueOf(this.espadachin.getVida());
        this.vidaLabel.setText("Vida: " + vida);
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());

        this.nombreLabel.setText(this.espadachin.getClass().getSimpleName());
    }

    private double obtenerProgresoDeVida(){
        return this.espadachin.getVida() / this.vidaInicial;
    }


}
