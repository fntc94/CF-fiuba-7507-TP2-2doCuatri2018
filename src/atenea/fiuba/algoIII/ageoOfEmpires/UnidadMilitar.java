package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class UnidadMilitar extends Unidad implements IAtacante {

    private IEstrategiaAtaque estrategiaAtaque;

    public UnidadMilitar(Posicion posicion, int vida, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, vida);
        this.estrategiaAtaque = estrategiaAtaque;
    }

    // IAtacante
    @Override
    public void atacar(IAtacable atacado){
        this.estrategiaAtaque.ejecutarAtaque(this, atacado);
    }

    @Override
    public int obtenerDanio(Unidad unidad) {
        return estrategiaAtaque.obtenerDanio(unidad);
    }

    @Override
    public int obtenerDanio(Edificio edificio) {
        return estrategiaAtaque.obtenerDanio(edificio);
    }
    // fin IAtacante

}
