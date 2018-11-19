package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IAtacante {

    void atacar(IAtacable atacable);

    int obtenerDanio(Unidad unidad);

    int obtenerDanio(PlazaCentral plazaCentral);
    int obtenerDanio(Cuartel cuartel);
    int obtenerDanio(Castillo castillo);

}
