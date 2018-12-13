package modelo.unidades;

import modelo.IEstrategiaAtaque;
import modelo.edificios.EstrategiaAtaqueArmaDeAsedio;
import modelo.edificios.IUnidadesCastilloFabrica;
import modelo.edificios.IUnidadesCuartelFabrica;
import modelo.edificios.IUnidadesPlazaCentralFabrica;
import modelo.posicion.Posicion;
import modelo.posicion.PosicionDeUnCasillero;

public class UnidadesFabrica implements IUnidadesPlazaCentralFabrica, IUnidadesCuartelFabrica, IUnidadesCastilloFabrica {

    private final int costoEnOroAldeano = 25;
    private final int costoEnOroArquero = 75;
    private final int costoEnOroEspadachin = 50;
    private final int costoEnOroArmaDeAsedio = 200;

    public int obtenerCostoAldeano(){
        return this.costoEnOroAldeano;
    }
    public Aldeano crearAldeano(Posicion posicion) {
        return new Aldeano(posicion);
    }

    public int obtenerCostoArquero() {
        return this.costoEnOroArquero;
    }
    public Arquero crearArquero(Posicion posicion) {
        IEstrategiaAtaque estrategiaAtaqueArquero = new EstrategiaAtaqueArquero();
        return new Arquero(posicion, estrategiaAtaqueArquero);
    }

    public int obtenerCostoEspadachin(){
        return this.costoEnOroEspadachin;
    }
    public Espadachin crearEspadachin(Posicion posicion){
        IEstrategiaAtaque estrategiaAtaqueEspadachin = new EstrategiaAtaqueEspadachin();
        return new Espadachin(posicion,estrategiaAtaqueEspadachin);

    }

    public int obtenerCostoArmaDeAsedio(){
        return this.costoEnOroArmaDeAsedio;
    }

    public ArmaDeAsedio crearArmaDeAsedio(Posicion posicion){
        IEstrategiaAtaque estrategiaAtaqueArmaDeAsedio = new EstrategiaAtaqueArmaDeAsedio();
        return new ArmaDeAsedio(posicion, estrategiaAtaqueArmaDeAsedio);
    }

}
