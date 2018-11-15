package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IReparador {

    void iniciarReparacion(IEdificioReparable edificioReparable);
    void continuarReparando();
    boolean estaReparando();

}
