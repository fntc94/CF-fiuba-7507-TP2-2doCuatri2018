package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio implements IAtacable {

    private int _vidaMaxima;
    private int _vidaActual;
    private Posicion _posicion;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(int vidaMaxima, int vidaActual, Posicion posicion){
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaActual;
        _posicion = posicion;
    }

    public ArmaDeAsedio(int vidaMaxima, Posicion posicion){
        this(vidaMaxima, vidaMaxima, posicion);
    }

    public ArmaDeAsedio(int vidaMaxima, int vidaActual){
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaActual;
        _posicion = null;
    }

    public ArmaDeAsedio(int vidaMaxima){
        this(vidaMaxima, vidaMaxima, null);
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

    @Override // IAtacable
    public void recibirDanio(int danio){
        this._vidaActual -= danio;
    }

    @Override
    public Posicion getPosicion() {
        return _posicion;
    }
}
