package vista.controladores;

import javafx.scene.Node;
import modelo.IPosicionable;

public interface IJuegoController {
    void setBotonera(Node node);

    boolean esDelJugador(IPosicionable posicionable);

    void cleanBotonera();
}
