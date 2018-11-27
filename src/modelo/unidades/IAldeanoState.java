package modelo.unidades;

import modelo.IEdificioReparable;
import modelo.edificios.IConstruccion;

public interface IAldeanoState {
    void iniciarConstruccion(IConstruccion edificioEnConstruccion);
    void iniciarReparacion(IEdificioReparable edificioReparable);
    void trabajar();
}
