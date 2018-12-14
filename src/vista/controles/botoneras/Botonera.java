package vista.controles.botoneras;

import javafx.scene.layout.GridPane;

public abstract class Botonera extends GridPane {

    public abstract void actualizarUI();
    public  abstract void habilitar();
    public abstract void deshabilitar();
}
