package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

public class Aldeano {

    private int _vidaMaxima = 50;
    private int _vidaActual;
    private IEstadoAldeano _estado = new AldeanoRecolector();

    void establecerEstado(IEstadoAldeano estado){
        _estado = estado;
    }

    public Aldeano(int vidaMaxima, int vidaInicial){
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
    }

    public Aldeano(int vidaMaxima){
        this(vidaMaxima, vidaMaxima);
    }

    public int getVidaActual() {
        return _vidaMaxima;
    }

    public void reparar(IEdificioReparable edificioReparable){
        _estado = new AldeanoReparador(edificioReparable, this);
        _estado.reparar(edificioReparable);
    }

    public void reparar(){
        _estado.reparar();
    }

    public int recolectarOro() {
        return _estado.recolectarOro();
    }


    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){

        _estado = new AldeanoConstructor(new CuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        _estado.iniciarConstruccion();

    }

    public void iniciarConstruccionDeCuartel(){

        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }

    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        _estado = new AldeanoConstructor(new PlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
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