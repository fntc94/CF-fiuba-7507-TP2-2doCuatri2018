package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IAtacable extends IPosicionable {

    void recibirAtaque(IAtacante atacante);
    int getVida();

}
