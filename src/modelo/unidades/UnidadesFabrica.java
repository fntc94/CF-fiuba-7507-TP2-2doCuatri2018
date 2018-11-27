package modelo.unidades;

import modelo.IEstrategiaAtaque;
import modelo.edificios.EstrategiaAtaqueArmaDeAsedio;
import modelo.edificios.IUnidadesCastilloFabrica;
import modelo.edificios.IUnidadesCuartelFabrica;
import modelo.edificios.IUnidadesPlazaCentralFabrica;
import modelo.posicion.PosicionDeUnCasillero;

public class UnidadesFabrica implements IUnidadesPlazaCentralFabrica, IUnidadesCuartelFabrica, IUnidadesCastilloFabrica {

    private final int costoEnOroAldeano = 25;
    private final int costoEnOroArquero = 75;
    private final int costoEnOroEspadachin = 50;
    private final int costoEnOroArmaDeAsedio = 200;

    public int obtenerCostoAldeano(){
        return this.costoEnOroAldeano;
    }
    public Aldeano crearAldeano() {
        return new Aldeano(new PosicionDeUnCasillero(0,0));
    }

    public int obtenerCostoArquero() {
        return this.costoEnOroArquero;
    }
    public Arquero crearArquero() {
        IEstrategiaAtaque estrategiaAtaqueArquero = new EstrategiaAtaqueArquero();
        return new Arquero(null, estrategiaAtaqueArquero);
    }

    public int obtenerCostoEspadachin(){
        return this.costoEnOroEspadachin;
    }
    public Espadachin crearEspadachin(){
        IEstrategiaAtaque estrategiaAtaqueEspadachin = new EstrategiaAtaqueEspadachin();
        return new Espadachin(new PosicionDeUnCasillero(0,0),estrategiaAtaqueEspadachin);

    }

    public int obtenerCostoArmaDeAsedio(){
        return this.costoEnOroArmaDeAsedio;
    }

    public ArmaDeAsedio crearArmaDeAsedio(){
        IEstrategiaAtaque estrategiaAtaqueArmaDeAsedio = new EstrategiaAtaqueArmaDeAsedio();
        return new ArmaDeAsedio(new PosicionDeUnCasillero(0,0), estrategiaAtaqueArmaDeAsedio);
    }

}
