package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio {

    private int _vidaMaxima;
    private int _vidaActual;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(int vidaMaxima, int vidaActual){
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaActual;
    }

    public ArmaDeAsedio(int vidaMaxima){
        this(vidaMaxima, vidaMaxima);
    }

    public int getVida(){
        return _vidaActual;
    }

    public boolean estaMontada() {
        return _estado.estaMontada();
    }

    public void montar() {
      _estado = new EstadoArmaDeAsedioMontada();
    }

    public void desmontar() {
       _estado = new EstadoArmaDeAsedioDesmontada();
    }

    public void atacar() {
        _estado.atacar();
    }

    public void mover() {
        _estado.mover();
    }

    public void atacar(IEdificioAtacable edificioAtacable) {
        _estado.atacar(edificioAtacable);

    }

    public void recibirAtaque(int danio){
        this._vidaActual -= danio;
    }
}
