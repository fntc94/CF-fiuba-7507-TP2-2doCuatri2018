package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IEdificioAtacable;

public interface IEstadoArmaDeAsedio {

    boolean estaMontada();
    void atacar();
    void mover();

    void atacar(IEdificioAtacable edificioAtacable);

}
