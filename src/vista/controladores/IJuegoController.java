package vista.controladores;

import javafx.scene.Node;

public interface IJuegoController {
    void setBotonera(Node node);

    boolean esDelJugador(String dueño);

    void cleanBotonera();
}
