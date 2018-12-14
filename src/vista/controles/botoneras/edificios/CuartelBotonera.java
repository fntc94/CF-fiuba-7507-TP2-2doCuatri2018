package vista.controles.botoneras.edificios;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import modelo.edificios.Cuartel;
import vista.controladores.edificios.CreacionUnidadesCuartelController;
import vista.controles.MapaControl;
import vista.controles.botoneras.VidaController;

public class CuartelBotonera extends EdificioBotonera<Cuartel> {


    @FXML private GridPane creacionUnidadesBotonera;

    public CuartelBotonera(Cuartel edificio, MapaControl mapa) {
        super(edificio, mapa);
    }

    @Override
    protected FXMLLoader getLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/edificios/CuartelBotonera.fxml"));
        loader.setController(this);

        loader.setControllerFactory(type -> {
            if(type == CreacionUnidadesCuartelController.class){
                CreacionUnidadesCuartelController controller = new CreacionUnidadesCuartelController(this.edificio, this.mapa);
                controller.onCreacionUnidad(this::deshabilitar);
                return controller;
            }
            if (type.equals(VidaController.class)) {
                VidaController vidaController = new VidaController(this.edificio);
                this.vidaController= vidaController;
                return vidaController;
            }
            else{
                return null;
            }
        });
        return loader;
    }

    @Override
    public void habilitar() {
        this.creacionUnidadesBotonera.setDisable(false);
    }

    @Override
    public void deshabilitar() {
        this.creacionUnidadesBotonera.setDisable(true);
    }
}
