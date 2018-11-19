package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IAtacante {

    void atacar(IAtacable atacable);

    int obtenerDanio(Aldeano aldeano);
    int obtenerDanio(Espadachin espadachin);
    int obtenerDanio(Arquero arquero);
    int obtenerDanio(ArmaDeAsedio armaDeAsedio);

    int obtenerDanio(PlazaCentral plazaCentral);
    int obtenerDanio(Cuartel cuartel);
    int obtenerDanio(Castillo castillo);

}
