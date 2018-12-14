package vista.controles.botoneras.unidades;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import modelo.unidades.Espadachin;
import vista.controles.MapaControl;
import vista.utilidades.ReproductorDeSonido;

public class EspadachinBotonera extends UnidadBotonera<Espadachin> {

    private MapaControl mapa;

    @FXML private VBox botoneraAtaque;

    @Override
    protected FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/vista/vistas/unidades/ArqueroBotonera.fxml"));
    }

    public EspadachinBotonera(Espadachin espadachin, MapaControl mapa) {
        super(espadachin, mapa);
        this.mapa = mapa;
    }


    public void handleAtaque(){
        mapa.estadoAtaque(this.unidad);
        new ReproductorDeSonido("ataque_espadachin.wav").reproducirSonido();
    }

    public void handleCancelar(){
        mapa.estadoSeleccionable();
    }

    @Override
    public void habilitar(){
        super.habilitar();
        this.botoneraAtaque.setDisable(false);
    }

    @Override
    public void deshabilitar(){
        super.deshabilitar();
        this.botoneraAtaque.setDisable(true);
    }

}
