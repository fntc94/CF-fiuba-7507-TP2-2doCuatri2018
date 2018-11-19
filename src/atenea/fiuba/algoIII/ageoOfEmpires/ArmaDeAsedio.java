package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio implements IAtacable {

    private final int VIDA_MAXIMA = 150;
    private int _vidaActual = VIDA_MAXIMA;
    private Posicion _posicion;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(Posicion posicion){
        _posicion = posicion;
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
