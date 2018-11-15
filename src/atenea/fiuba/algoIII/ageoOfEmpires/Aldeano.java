package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

public class Aldeano implements IRecolectorOro, IConstructor, IReparador {

    private int _vidaMaxima = 50;
    private int _vidaActual;
    private IEstadoAldeano _estadoAldeano = new EstadoAldeanoRecolector();

    void establecerEstado(IEstadoAldeano estado){
        _estadoAldeano = estado;
    }

    int getVidaActual() {
        return _vidaActual;
    }

    public Aldeano(int vidaMaxima, int vidaInicial){
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
    }

    public Aldeano(int vidaMaxima){
        this(vidaMaxima, vidaMaxima);
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable){
        _estadoAldeano = new EstadoAldeanoReparador(edificioReparable, this);
        _estadoAldeano.iniciarReparacion(edificioReparable);
    }

    public void continuarReparacion(){
        _estadoAldeano.continuarReparacion();
    }

    @Override
    public boolean estaReparando() {
        return _estadoAldeano.estaReparando();
    }

    @Override
    public boolean estaRecolectandoOro() {
        return _estadoAldeano.estaRecolectandoOro();
    }

    public int recolectarOro() {
        return _estadoAldeano.recolectarOro();
    }


    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){

        _estadoAldeano = new EstadoAldeanoConstructor(new CuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        _estadoAldeano.iniciarConstruccion();

    }

    public void iniciarConstruccionDeCuartel(){

        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }

    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        _estadoAldeano = new EstadoAldeanoConstructor(new PlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        _estadoAldeano.iniciarConstruccion();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void continuarConstruyendo() {

        _estadoAldeano.continuarConstruccion();
    }

    public boolean estaConstruyendo() {

        return _estadoAldeano.estaConstruyendo();
    }
}