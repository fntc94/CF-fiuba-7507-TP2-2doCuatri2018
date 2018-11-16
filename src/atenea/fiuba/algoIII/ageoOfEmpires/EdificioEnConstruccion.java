package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificioEnConstruccion<TEdificio> {

    private int _turnosQueTardaEnConstruir;
    private int _turnosEnConstruccion = 0;
    private TEdificio _edificioConstruido;

    EdificioEnConstruccion(int turnosEnConstruir, TEdificio edificioConstruido){
        _turnosQueTardaEnConstruir = turnosEnConstruir;
        _edificioConstruido = edificioConstruido;
    }

    public void avanzarConstruccion(){
        _turnosEnConstruccion += 1;
    }

    public boolean estaTerminado(){
        return _turnosEnConstruccion == _turnosQueTardaEnConstruir;
    }

    public TEdificio obtenerEdificioTerminado(){
        if(!estaTerminado()){
            throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
        }

        return _edificioConstruido;
    }

}
