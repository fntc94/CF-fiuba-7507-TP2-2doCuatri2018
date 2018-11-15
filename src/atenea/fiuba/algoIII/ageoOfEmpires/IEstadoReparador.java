package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IEstadoReparador {

    void iniciarReparacion(IEdificioReparable edificioReparable);
    void continuarReparacion();
    void darPorTerminadaLaReparacion();
    boolean estaReparando();
}
