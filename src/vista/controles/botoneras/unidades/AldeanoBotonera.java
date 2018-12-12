package vista.controles.botoneras.unidades;

import javafx.fxml.FXMLLoader;
import modelo.unidades.Aldeano;
import vista.controladores.ConstruccionEdificiosController;
import vista.controles.MapaControl;

public class AldeanoBotonera extends UnidadBotonera<Aldeano> {

    public AldeanoBotonera(Aldeano unidad, MapaControl mapa) {
        super(unidad, mapa);
    }

    @Override
    protected FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/vista/vistas/AldeanoBotonera.fxml"));
    }

    @Override
    protected Object getController(Class<?> type){

        if(type.equals(ConstruccionEdificiosController.class)){
            return new ConstruccionEdificiosController(this.unidad, this.mapa);
        }
        else{
            return super.getController(type);
        }

    }
}

