package vista.controles.botoneras.unidades;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import modelo.Unidad;
import vista.controladores.MovimientoController;
import vista.controles.MapaControl;
import vista.controles.botoneras.Botonera;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class UnidadBotonera<TUnidad extends Unidad> extends Botonera implements Initializable {

    @FXML
    private ProgressBar vidaProgressBar;
    @FXML private Label vidaLabel;
    @FXML private Label nombreLabel;
    protected TUnidad unidad;
    private double vidaInicial;
    protected MapaControl mapa;



    public UnidadBotonera(TUnidad unidad, MapaControl mapa){

        super();
        this.unidad = unidad;
        this.vidaInicial = unidad.getVida();
        this.mapa = mapa;

        FXMLLoader loader = this.getLoader();
        loader.setRoot(this);
        loader.setController(this);
        loader.setControllerFactory(this::getController);

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
        this.nombreLabel.setText(this.unidad.getClass().getSimpleName());
    }

    protected abstract FXMLLoader getLoader();

    protected Object getController(Class<?> type){

        if(type.equals(MovimientoController.class)){
            return new MovimientoController(unidad, mapa);
        }

        else {
            try {
                return type.newInstance();
            } catch (Exception exc) {
                exc.printStackTrace();
                throw new RuntimeException(exc);
            }
        }
    }

    private double obtenerProgresoDeVida(){
        return this.unidad.getVida() / this.vidaInicial;
    }
    private void setVidaLabel(){
        String vidaInicial = String.valueOf((int)this.vidaInicial);
        String vidaActual = String.valueOf(this.unidad.getVida());
        String texto = String.format("Vida: %s/%s", vidaActual, vidaInicial);

        this.vidaLabel.setText(texto);

    }

    public void actualizarUI(){
        this.vidaProgressBar.setProgress(this.obtenerProgresoDeVida());
        this.setVidaLabel();
    }

}
