package vista.controles;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import modelo.IPosicionable;
import vista.controladores.ArmaDeAsedioController;
import vista.controladores.IPosicionController;
import vista.controladores.IPosicionableController;

import java.io.IOException;

public class ArmaDeAsedioVista extends AnchorPane {


    public ArmaDeAsedioVista(IPosicionableController controller){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/ArmaDeAsedio.fxml"));
        loader.setRoot(this);
        loader.setController(controller);

        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        String color = controller.getColor();
        String classSimpleName = controller.getPosicionable().getClass().getSimpleName();
        String css = String.format("-fx-background-image: url(/vista/imagenes/%s_%s.png)", classSimpleName, color);
        this.setStyle(css);
    }

}
