package vista.controladores.edificios;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import modelo.edificios.PlazaCentral;
import modelo.unidades.Aldeano;
import vista.controles.MapaControl;

import java.awt.event.MouseEvent;

public class CreacionUnidadesPlazaCentralController {



    @FXML
    private ImageView aldeanoImageView;

    private PlazaCentral plazaCentral;
    private MapaControl mapaControl;

    public CreacionUnidadesPlazaCentralController(PlazaCentral plazaCentral, MapaControl mapaControl){

        this.plazaCentral = plazaCentral;
        this.mapaControl = mapaControl;
    }


    public void dragAldeano(javafx.scene.input.MouseEvent event) {

        this.mapaControl.setDragSource(this.plazaCentral);

        Dragboard db = this.aldeanoImageView.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();

        content.put(DataFormat.IMAGE, this.aldeanoImageView.getImage());
        content.put(DataFormat.PLAIN_TEXT, "Aldeano");
        db.setContent(content);

        event.consume();
    }
}
