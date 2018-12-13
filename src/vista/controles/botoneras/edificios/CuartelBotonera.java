package vista.controles.botoneras.edificios;

import javafx.fxml.FXMLLoader;
import modelo.edificios.Cuartel;
import vista.controladores.edificios.CreacionUnidadesCuartelController;
import vista.controles.MapaControl;
import vista.controles.botoneras.VidaController;

public class CuartelBotonera extends EdificioBotonera<Cuartel> {

    public CuartelBotonera(Cuartel edificio, MapaControl mapa) {
        super(edificio, mapa);
    }

    @Override
    protected FXMLLoader getLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/edificios/CuartelBotonera.fxml"));
        loader.setController(this);

        loader.setControllerFactory(type -> {
            if(type == CreacionUnidadesCuartelController.class){
                return new CreacionUnidadesCuartelController(this.edificio, this.mapa);
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
}