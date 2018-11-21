package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

public class EdificioEnConstruccion<TEdificio> {

    private int turnosQueTardaEnConstruir;
    private int turnosEnConstruccion = 0;
    private TEdificio edificioConstruido;

    EdificioEnConstruccion(int turnosEnConstruir, TEdificio edificioConstruido){
        this.turnosQueTardaEnConstruir = turnosEnConstruir;
        this.edificioConstruido = edificioConstruido;
    }

    public void avanzarConstruccion(){
        this.turnosEnConstruccion += 1;
    }

    public boolean estaTerminado(){
        return this.turnosEnConstruccion == this.turnosQueTardaEnConstruir;
    }

    public TEdificio obtenerEdificioTerminado(){
        if(!estaTerminado()){
            throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
        }

        return this.edificioConstruido;
    }

}
