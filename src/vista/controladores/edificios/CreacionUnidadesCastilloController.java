package vista.controladores.edificios;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import modelo.edificios.Castillo;
import modelo.edificios.PlazaCentral;
import modelo.unidades.ArmaDeAsedio;
import vista.controles.MapaControl;

public class CreacionUnidadesCastilloController {

    @FXML
    private ImageView armaDeAsedioImageView;

    private Castillo castillo;
    private MapaControl mapaControl;

    public CreacionUnidadesCastilloController(Castillo castillo, MapaControl mapaControl){

        this.castillo = castillo;
        this.mapaControl = mapaControl;
    }


    public void dragArmaDeAsedio(javafx.scene.input.MouseEvent event) {

        this.mapaControl.setDragSource(this.castillo);

        Dragboard db = this.armaDeAsedioImageView.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();

        content.put(DataFormat.IMAGE, this.armaDeAsedioImageView.getImage());
        content.put(DataFormat.PLAIN_TEXT, ArmaDeAsedio.class.getSimpleName());
        db.setContent(content);

        event.consume();
    }
}
