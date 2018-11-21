package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

public interface IAtacable extends IPosicionable {

    void recibirAtaque(IAtacante atacante);
    int getVida();

}
