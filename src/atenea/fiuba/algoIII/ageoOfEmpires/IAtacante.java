package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IAtacante {

    void atacar(IAtacable atacable);
    int obtenerDanio(Unidad unidad);
    int obtenerDanio(Edificio edificio);

}
