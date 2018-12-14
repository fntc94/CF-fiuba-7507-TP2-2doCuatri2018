package vista.controladores;

import javafx.scene.Node;
import modelo.IPosicionable;
import vista.controles.botoneras.Botonera;

public interface IJuegoController {
    void setBotonera(Botonera botonera);

    boolean esDelJugador(IPosicionable posicionable);

    void habilitarBotonera();
    void deshabilitarBotonera();
}
