package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio {

    private int _vidaMaxima;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(int vidaMaxima){

        _vidaMaxima = vidaMaxima;
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
