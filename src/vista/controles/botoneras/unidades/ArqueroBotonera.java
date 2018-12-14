package vista.controles.botoneras.unidades;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import modelo.unidades.Arquero;
import vista.controles.MapaControl;
import vista.utilidades.ReproductorDeSonido;


public class ArqueroBotonera extends UnidadBotonera<Arquero> {

    private MapaControl mapa;

    @FXML
    private VBox botoneraAtaque;

    @Override
    protected FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/vista/vistas/unidades/ArqueroBotonera.fxml"));
    }

    public ArqueroBotonera(Arquero arquero, MapaControl mapa) {
        super(arquero, mapa);
        this.mapa = mapa;
    }


    public void handleAtaque(){
        mapa.estadoAtaque(this.unidad);
        new ReproductorDeSonido("ataque_arquero.wav").reproducirSonido();
        this.deshabilitar();
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
