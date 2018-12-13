package modelo;

import java.util.function.Consumer;

public interface IAtacable extends IPosicionable {

    void recibirAtaque(IAtacante atacante);
    int getVida();
    void onDestruido(Consumer<IAtacable> atacable);

}
