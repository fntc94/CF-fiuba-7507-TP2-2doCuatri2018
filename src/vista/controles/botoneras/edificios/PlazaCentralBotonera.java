package vista.controles.botoneras.edificios;

import javafx.fxml.FXMLLoader;
import modelo.edificios.PlazaCentral;
import vista.controladores.edificios.CreacionUnidadesPlazaCentralController;
import vista.controles.MapaControl;


public class PlazaCentralBotonera extends EdificioBotonera<PlazaCentral> {


    public PlazaCentralBotonera(PlazaCentral edificio, MapaControl mapa) {
        super(edificio, mapa);
    }

    @Override
    protected FXMLLoader getLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/edificios/PlazaCentralBotonera.fxml"));
        loader.setController(this);

        loader.setControllerFactory(type -> {
            if(type == CreacionUnidadesPlazaCentralController.class){
                return new CreacionUnidadesPlazaCentralController(this.edificio, this.mapa);
            }
            else{
                return null;
            }
        });
        return loader;
    }


}
