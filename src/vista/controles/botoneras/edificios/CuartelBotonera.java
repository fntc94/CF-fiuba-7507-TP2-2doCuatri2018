package vista.controles.botoneras.edificios;

import javafx.fxml.FXMLLoader;
import modelo.edificios.Cuartel;
import vista.controladores.edificios.CreacionUnidadesCuartelController;
import vista.controles.MapaControl;

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
            else{
                return null;
            }
        });
        return loader;
    }
}
