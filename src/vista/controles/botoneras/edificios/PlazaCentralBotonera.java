package vista.controles.botoneras.edificios;

import javafx.fxml.FXMLLoader;
import modelo.edificios.PlazaCentral;
import vista.controladores.edificios.CreacionUnidadesPlazaCentralController;
import vista.controles.MapaControl;
import vista.controles.botoneras.VidaController;


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
