package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.IEstadoReparador;

public abstract class Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private Posicion posicion;
    private final int VIDA_MAXIMA;
    private final int VELOCIDAD_DE_REPARACION;

    protected int vidaActual;
    private IEstadoReparador reparadorActivo;


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
    public void recibirReparador(IEstadoReparador reparador) {

        if(this.reparadorActivo == null){
            this.reparadorActivo = reparador;
        }

        else if (this.reparadorActivo != reparador){
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
