package controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class AldeanoController {

    private JuegoController juegoCotroller;

    public void handleOnMouseClicked(MouseEvent mouseEvent) {

        juegoCotroller.setBotonera("Botonera para Aldeano");

    }

    public void init(JuegoController juegoCotroller){

        this.juegoCotroller = juegoCotroller;
    }
}
