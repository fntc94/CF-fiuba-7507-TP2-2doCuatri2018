package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends Edificio implements IEdificioReparable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 1000;
    private static final int VELOCIDAD_DE_REPARACION = 15;
    private static final int RANGO_DE_ATAQUE = 3;
    private static final int DANIO = 20;
    private IUnidadesCastilloFabrica _fabricaDeUnidades;

    public Castillo(Posicion posicion, IUnidadesCastilloFabrica fabricaDeUnidades) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoArmaDeAsedio(){
        return _fabricaDeUnidades.obtenerCostoArmaDeAsedio();
    }

    public ArmaDeAsedio crearArmaDeAsedio(){
        return _fabricaDeUnidades.crearArmaDeAsedio();
    }


    @Override
    public void atacar(IAtacable atacable) {
        if(!estaDentroDelRangoDeAtaque(atacable)){
            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
        }
        atacable.recibirAtaque(this);
    }

    @Override
    public int obtenerDanio(Unidad unidad) {
        return DANIO;
    }

    @Override
    public int obtenerDanio(Edificio edificio) {
        return DANIO;
    }

    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
    }}
