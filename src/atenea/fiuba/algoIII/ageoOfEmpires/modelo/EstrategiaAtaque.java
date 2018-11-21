package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.UnidadFueraDeRangoDeAtaqueExcepcion;

public abstract class EstrategiaAtaque<TAtacante extends IAtacante> implements IEstrategiaAtaque<TAtacante> {

    private final int RANGO_DE_ATAQUE;
    private final int DANIO_A_UNIDAD;
    private final int DANIO_A_EDIFICIO;

    public EstrategiaAtaque(int rangDeAtaque, int danioAUnidad, int danioAEdificio){
        this.RANGO_DE_ATAQUE = rangDeAtaque;
        this.DANIO_A_UNIDAD = danioAUnidad;
        this.DANIO_A_EDIFICIO = danioAEdificio;
    }

    @Override
    public void ejecutarAtaque(TAtacante atacante, IAtacable atacado){
        if(!estaDentroDelRangoDeAtaque(atacado, atacante)){
            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
        }
        atacado.recibirAtaque(atacante);
    }

    @Override
    public int obtenerDanio(Unidad unidad) {
        return DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(Edificio edificio) {
        return DANIO_A_EDIFICIO;
    }

    private boolean estaDentroDelRangoDeAtaque(IAtacable atacado, IAtacante atacante){
        return atacante.getPosicion().distanciaA(atacado.getPosicion()) <= RANGO_DE_ATAQUE;
    }
}
