package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import modelo.unidades.Aldeano;
import vista.controladores.IPosicionController;
import vista.controladores.MiniMapaController;
import vista.controladores.MovimientoController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AldeanoBotonera extends GridPane implements Initializable {


    @FXML private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private Label nombreLabel;
    private Aldeano aldeano;
    private double vidaInicial;

    public AldeanoBotonera(Aldeano aldeano, MapaControl mapa){

        super();
        this.aldeano = aldeano;
        this.vidaInicial = aldeano.getVida();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/AldeanoBotonera.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        loader.setControllerFactory(type -> {

            if(type.equals(MovimientoController.class)){
                return new MovimientoController(aldeano, mapa);
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
        String vida = String.valueOf(this.aldeano.getVida());
        this.vidaLabel.setText("Vida: " + vida);
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());

        this.nombreLabel.setText(this.aldeano.getClass().getSimpleName());
    }

    private double obtenerProgresoDeVida(){
        return this.aldeano.getVida() / this.vidaInicial;
    }

}
