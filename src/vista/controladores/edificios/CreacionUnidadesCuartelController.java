package vista.controladores.edificios;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import vista.controles.MapaControl;

public class CreacionUnidadesCuartelController {


    @FXML private ImageView espadachinImageView;
    @FXML private ImageView arqueroImageView;

    private Cuartel cuartel;
    private MapaControl mapaControl;

    public CreacionUnidadesCuartelController(Cuartel cuartel, MapaControl mapaControl){

        this.cuartel = cuartel;
        this.mapaControl = mapaControl;
    }


    public void dragEspadachin(javafx.scene.input.MouseEvent event) {

        this.mapaControl.setDragSource(this.cuartel);

        Dragboard db = this.espadachinImageView.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();

        content.put(DataFormat.IMAGE, this.espadachinImageView.getImage());
        content.put(DataFormat.PLAIN_TEXT, Espadachin.class.getSimpleName());
        db.setContent(content);

        event.consume();
    }

    public void dragArquero(javafx.scene.input.MouseEvent event) {

        this.mapaControl.setDragSource(this.cuartel);

        Dragboard db = this.arqueroImageView.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();

        content.put(DataFormat.IMAGE, this.arqueroImageView.getImage());
        content.put(DataFormat.PLAIN_TEXT, Arquero.class.getSimpleName());
        db.setContent(content);

        event.consume();
    }
}
