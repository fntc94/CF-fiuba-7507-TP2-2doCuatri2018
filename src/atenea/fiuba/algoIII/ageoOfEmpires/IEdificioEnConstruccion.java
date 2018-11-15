package atenea.fiuba.algoIII.ageoOfEmpires;

public interface IEdificioEnConstruccion<TEdificioTerminado> {

    void avanzarConstruccion();
    boolean estaTerminado();
    TEdificioTerminado obtenerEdificioTerminado();

}
