package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import modelo.unidades.Aldeano;
import vista.controladores.MiniMapaController;
import vista.controladores.MovimientoController;
import java.io.IOException;



public class AldeanoBotonera extends GridPane {


    @FXML private GridPane botoneraMovimiento;

    public AldeanoBotonera(Aldeano aldeano, MapaControl mapa){

        super();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/AldeanoBotonera.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        loader.setControllerFactory(type -> {

            if(type.equals(MovimientoController.class)){
                return new MovimientoController(aldeano, mapa);
            }

            else {
                // default behavior for controllerFactory:
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc); // fatal, just bail...
                }
            }

        });


        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
