package modelo;

import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;

public abstract class Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private Posicion posicion;
    private final int VIDA_MAXIMA;
    private final int VELOCIDAD_DE_REPARACION;

    protected int vidaActual;
    private Aldeano reparador;


    private Runnable reparacionTerminadaHandler = () -> {};

    protected Edificio(Posicion posicion, int vidaMaxima, int velocidadDeReparacion){
        this.posicion = posicion;
        this.VIDA_MAXIMA = vidaMaxima;
        this.vidaActual = VIDA_MAXIMA;
        this.VELOCIDAD_DE_REPARACION = velocidadDeReparacion;
    }

    public int getVida(){
        return this.vidaActual;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    @Override // IEdificioReparable
    public void recibirReparador(Aldeano reparador) {

        if(this.reparador == null){
            this.reparador = reparador;
        }

        else if (this.reparador != reparador){
            return;
        }

        vidaActual += VELOCIDAD_DE_REPARACION;

        if(this.vidaActual > this.VIDA_MAXIMA){
            this.vidaActual = this.VIDA_MAXIMA;
            this.reparacionTerminadaHandler.run();
        }
    }

    @Override
    public void onReparacionTerminada(Runnable reparacionTerminadaHandler){
        this.reparacionTerminadaHandler = reparacionTerminadaHandler;
    }
    // fin IEdificioReparable

    @Override // IAtacable
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);

        if(this.vidaActual <= danio){
            this.vidaActual = 0;
            return;
        }

        this.vidaActual -= danio;
    }



}
