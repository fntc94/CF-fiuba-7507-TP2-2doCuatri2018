package vista.controles.botoneras.unidades;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import modelo.unidades.Aldeano;
import vista.controladores.ConstruccionEdificiosController;
import vista.controles.MapaControl;

public class AldeanoBotonera extends UnidadBotonera<Aldeano> {


    @FXML private GridPane botoneraConstruccion;

    public AldeanoBotonera(Aldeano unidad, MapaControl mapa) {
        super(unidad, mapa);
    }

    @Override
    protected FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/vista/vistas/unidades/AldeanoBotonera.fxml"));
    }

    @Override
    protected Object getController(Class<?> type){

        if(type.equals(ConstruccionEdificiosController.class)){
            ConstruccionEdificiosController controller = new ConstruccionEdificiosController(this.unidad, this.mapa);
            controller.onCreacionUnidad(this::deshabilitar);
            return controller;
        }
        else{
            return super.getController(type);
        }

    }

    @Override
    public void habilitar(){
        super.habilitar();
        this.botoneraConstruccion.setDisable(false);
    }

    @Override
    public void deshabilitar(){
        super.deshabilitar();
        this.botoneraConstruccion.setDisable(true);
    }
}

