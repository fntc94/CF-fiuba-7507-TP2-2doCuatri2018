package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IEstadoReparador {

    void iniciarReparacion(IEdificioReparable edificioReparable);
    void continuarReparando();
    void darPorTerminadaLaReparacion();
    boolean estaReparando();
}
