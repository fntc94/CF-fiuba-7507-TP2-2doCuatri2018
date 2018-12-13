package vista.controladores;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import modelo.Unidad;
import modelo.unidades.Aldeano;
import vista.controles.MapaControl;

public class ConstruccionEdificiosController {
    private Aldeano aldeano;
    private MapaControl mapa;
    @FXML private ImageView plazaCentral;
    @FXML private ImageView cuartel;

    public ConstruccionEdificiosController(Unidad aldeano, MapaControl mapa){
        this.aldeano = (Aldeano) aldeano;
        this.mapa = mapa;
    }

    public void dragginPlaza(MouseEvent event){

        this.mapa.setDragSource(this.aldeano);

        Dragboard db = plazaCentral.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();

        content.put(DataFormat.IMAGE, this.plazaCentral.getImage());
        content.put(DataFormat.PLAIN_TEXT, "plaza");    // Esto es para reconocer que recibe el mapa
        db.setContent(content);


        event.consume();

    }

    public void dragginCuartel(MouseEvent event){
        Dragboard db = cuartel.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();

        content.put(DataFormat.IMAGE, this.cuartel.getImage());
        content.put(DataFormat.PLAIN_TEXT, "cuartel");  // Esto es para reconocer que recibe el mapa
        db.setContent(content);

        event.consume();
    }

}
