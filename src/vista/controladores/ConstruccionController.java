package vista.controladores;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import modelo.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.posicion.PosicionDeUnCasillero;
import modelo.unidades.UnidadesFabrica;
import vista.controles.MapaControl;

public class ConstruccionController{
    private MapaControl mapa;
    @FXML private ImageView plazaCentral;
    @FXML private ImageView cuartel;

    public ConstruccionController(MapaControl mapa){
        this.mapa = mapa;
    }

    public void dragginPlaza(MouseEvent mouseEvent){
        Dragboard db = plazaCentral.startDragAndDrop(TransferMode.ANY);

        Edificio nuevaPlaza = new PlazaCentral(new PosicionDeUnCasillero(9,9), new UnidadesFabrica());

        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putImage(this.plazaCentral.getImage());
        db.setContent(content);

        mouseEvent.consume();
    }

    public void dragginCuartel(MouseEvent mouseEvent){
        Dragboard db = cuartel.startDragAndDrop(TransferMode.ANY);

        Edificio nuevaPlaza = new PlazaCentral(new PosicionDeUnCasillero(9,9), new UnidadesFabrica());

        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putImage(this.cuartel.getImage());
        db.setContent(content);

        mouseEvent.consume();
    }

}
