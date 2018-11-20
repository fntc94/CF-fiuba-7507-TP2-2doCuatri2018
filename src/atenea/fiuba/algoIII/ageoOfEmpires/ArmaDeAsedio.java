package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 150;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();

    public ArmaDeAsedio(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
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

}
