package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

public interface IEstrategiaAtaque<TAtacante extends IAtacante> {

    void ejecutarAtaque(TAtacante atacante, IAtacable atacable);
    int obtenerDanio(Unidad unidad);
    int obtenerDanio(Edificio edificio);

}
