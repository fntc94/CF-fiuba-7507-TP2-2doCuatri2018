package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class Unidad implements IPosicionable, IAtacable, IMovible {

    protected int _vida;
    private Posicion posicion;
    private Movimiento movimiento;

    protected Unidad(Posicion posicion, int vida){
        this.posicion = posicion;
        this._vida = vida;
        this.movimiento = new Movimiento();
    }

    public int getVida() {
        return _vida;
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override // IAtacable
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);

        if(this._vida <= danio){
            this._vida = 0;
            return;
        }

        this._vida -= danio;
    }

    public void mover(IDireccion direccion){
        movimiento.hacia(direccion);

        this.posicion = movimiento.calcularPosSiguiente(this.posicion);
    }

    public boolean estaEnPosicion(Posicion pos){
        return this.posicion.seSuperponeCon(pos);
    }
}
