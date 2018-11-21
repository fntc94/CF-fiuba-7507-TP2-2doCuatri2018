package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

public interface IAtacante extends IPosicionable {

    void atacar(IAtacable atacable);
    int obtenerDanio(Unidad unidad);
    int obtenerDanio(Edificio edificio);

}
