package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class AldeanoController {


    public void handleClick(MouseEvent mouseEvent) {

        new Alert(Alert.AlertType.CONFIRMATION, "Aldeano!").show();

    }


}
