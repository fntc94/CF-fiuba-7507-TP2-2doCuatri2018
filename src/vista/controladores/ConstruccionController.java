package vista.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import modelo.Edificio;
import modelo.IPosicionable;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;
import modelo.posicion.Casillero;
import modelo.posicion.Limite;
import modelo.posicion.PosicionCuadrado;
import modelo.posicion.PosicionDeUnCasillero;
import modelo.unidades.UnidadesFabrica;
import vista.controles.MapaControl;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class ConstruccionController{
    private MapaControl mapa;
    @FXML private ImageView plazaCentral;
    @FXML private ImageView cuartel;

    public ConstruccionController(MapaControl mapa){
        this.mapa = mapa;
    }

    public void dragginPlaza(MouseEvent event){
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
