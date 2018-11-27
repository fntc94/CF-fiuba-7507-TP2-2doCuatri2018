package modelo.edificios;

import modelo.UnEdificioNoPuedeSerConstruidoPorDosAldeanosALaVezException;
import modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Construccion<TEdificio> implements IConstruccion<TEdificio> {

    protected Posicion posicion;
    private int turnosQueTardaEnConstruir;
    private int turnosEnConstruccion = 0;

    private Aldeano constructor;

    private Consumer<TEdificio> construccionTerminadaHanlder = (TEdificio edificio) -> {};
    private List<Consumer<TEdificio>> handlers = new ArrayList<>();

    Construccion(Posicion posicion, int turnosEnConstruir){
        this.posicion = posicion;
        this.turnosQueTardaEnConstruir = turnosEnConstruir;
        this.handlers.add((edificio) -> {});
    }

    public void recibirConstructor(Aldeano aldeano){

        if(this.constructor == null){
            this.constructor = aldeano;
        }

        else if(this.constructor != aldeano){
            throw new UnEdificioNoPuedeSerConstruidoPorDosAldeanosALaVezException();
        }

        this.turnosEnConstruccion += 1;

        if(this.estaTerminado()){
            for(Consumer<TEdificio> hanlder: this.handlers){
                hanlder.accept(this.obtenerEdificioTerminado());
            }
        }
    }

    private boolean estaTerminado(){
        return this.turnosEnConstruccion == this.turnosQueTardaEnConstruir;
    }

    public TEdificio obtenerEdificioTerminado(){

        if(!estaTerminado()){
            throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
        }

        return this.crearEdificio();
    }

    protected abstract TEdificio crearEdificio();

    public void onConstruccionTerminada(Consumer<TEdificio> contruccionTerminadaHanlder){
        this.handlers.add(contruccionTerminadaHanlder);
    }

}
