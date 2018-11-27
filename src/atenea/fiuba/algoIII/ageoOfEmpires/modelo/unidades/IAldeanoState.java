package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IConstruccion;

public interface IAldeanoState {
    void iniciarConstruccion(IConstruccion edificioEnConstruccion);
    void iniciarReparacion(IEdificioReparable edificioReparable);
    void trabajar();
}
