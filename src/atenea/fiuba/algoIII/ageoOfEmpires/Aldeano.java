package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

public class Aldeano implements IRecolectorOro, IConstructor, IReparador {

    private int _vidaMaxima = 50;
    private EdificiosEnConstruccionFabrica _fabricaDeEdificios;
    private int _vidaActual;
    private IEstadoAldeano _estadoAldeano = new EstadoAldeanoRecolector();

    void establecerEstado(IEstadoAldeano estado){
        _estadoAldeano = estado;
    }

    int getVidaActual() {
        return _vidaActual;
    }

    public Aldeano(int vidaMaxima, int vidaInicial, EdificiosEnConstruccionFabrica fabricaDeEdificiosEnConstruccion){
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
        _fabricaDeEdificios = fabricaDeEdificiosEnConstruccion;
    }

    public Aldeano(int vidaMaxima, EdificiosEnConstruccionFabrica fabricaDeEdificios){
        this(vidaMaxima, vidaMaxima, fabricaDeEdificios);
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return _estadoAldeano.recolectarOro();
    }

    @Override
    public boolean estaRecolectandoOro() {
        return _estadoAldeano.estaRecolectandoOro();
    }
    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public boolean estaConstruyendo() {
        return _estadoAldeano.estaConstruyendo();
    }

    @Override
    public void continuarConstruyendo() {
        _estadoAldeano.continuarConstruyendo();
    }
    //fin IConstructor

    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable){
        _estadoAldeano = new EstadoAldeanoReparador(edificioReparable, this);
        _estadoAldeano.iniciarReparacion(edificioReparable);
    }

    @Override
    public boolean estaReparando() {
        return _estadoAldeano.estaReparando();
    }

    @Override
    public void continuarReparando(){
        _estadoAldeano.continuarReparando();
    }
    //fin IReparador


    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        _estadoAldeano = new EstadoAldeanoConstructor(_fabricaDeEdificios.obtenerPlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        _estadoAldeano.iniciarConstruccion();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){

        _estadoAldeano = new EstadoAldeanoConstructor(_fabricaDeEdificios.obtenerCuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        _estadoAldeano.iniciarConstruccion();

    }

    public void iniciarConstruccionDeCuartel(){
        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }
}