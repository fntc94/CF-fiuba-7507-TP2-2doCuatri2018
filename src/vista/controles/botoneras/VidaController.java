package vista.controles.botoneras;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.IAtacable;

import java.net.URL;
import java.util.ResourceBundle;

public class VidaController implements Initializable {

    @FXML private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private ImageView imagen;

    private IAtacable atacable;
    private double vidaInicial;

    public VidaController(IAtacable atacable){
        this.atacable = atacable;
        this.vidaInicial = atacable.getVida();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setVidaLabel();
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());

        String className = this.atacable.getClass().getSimpleName();
        String imagenPath = String.format("/vista/imagenes/botonera/%s.png", className);
        this.imagen.setImage(new Image(imagenPath));
    }

    private double obtenerProgresoDeVida(){
        return this.atacable.getVida() / this.vidaInicial;
    }
    private void setVidaLabel(){
        String vidaInicial = String.valueOf((int)this.vidaInicial);
        String vidaActual = String.valueOf(this.atacable.getVida());
        String texto = String.format("Vida: %s/%s", vidaActual, vidaInicial);

        this.vidaLabel.setText(texto);

    }

    public void actualizarUI(){
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());
        this.setVidaLabel();
    }
}
