package vista.controles.botoneras.edificios;

import javafx.fxml.FXMLLoader;
import modelo.edificios.Castillo;
import vista.controladores.edificios.CreacionUnidadesCastilloController;
import vista.controladores.edificios.CreacionUnidadesCuartelController;
import vista.controles.MapaControl;

public class CastilloBotonera extends EdificioBotonera<Castillo> {

    public CastilloBotonera(Castillo unidad, MapaControl mapa) {
        super(unidad, mapa);
    }

    @Override
    protected FXMLLoader getLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/edificios/CastilloBotonera.fxml"));
        loader.setController(this);

        loader.setControllerFactory(type -> {
            if(type == CreacionUnidadesCastilloController.class){
                return new CreacionUnidadesCastilloController(this.edificio, this.mapa);
            }
            else{
                return null;
            }
        });
        return loader;
    }
}
