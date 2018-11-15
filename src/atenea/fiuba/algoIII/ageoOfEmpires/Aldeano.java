package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

public class Aldeano {

    private int _vidaMaxima = 50;
    private int _vidaActual;
    private IEstadoAldeano _estado = new EstadoAldeanoRecolector();

    void establecerEstado(IEstadoAldeano estado){
        _estado = estado;
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
        _estado = new EstadoAldeanoReparador(edificioReparable, this);
        _estado.iniciarReparacion(edificioReparable);
    }

    public void continuarReparacion(){
        _estado.continuarReparacion();
    }

    public int recolectarOro() {
        return _estado.recolectarOro();
    }


    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){

        _estado = new EstadoAldeanoConstructor(new CuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        _estado.iniciarConstruccion();

    }

    public void iniciarConstruccionDeCuartel(){

        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }

    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        _estado = new EstadoAldeanoConstructor(new PlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        _estado.iniciarConstruccion();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void continuarConstruccion() {

        _estado.continuarConstruccion();
    }

    public boolean estaConstruyendo() {

        return _estado.estaConstruyendo();
    }
}