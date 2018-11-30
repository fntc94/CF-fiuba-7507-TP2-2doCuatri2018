package modelo.juego;

import modelo.Edificio;
import modelo.IPosicionable;
import modelo.edificios.Castillo;
import modelo.edificios.Construcciones;
import modelo.edificios.EstrategiaAtaqueCastillo;
import modelo.edificios.PlazaCentral;
import modelo.excepciones.OroInsuficienteException;
import modelo.posicion.*;
import modelo.unidades.*;

public class Jugador {
    private Mapa mapa;
    private Plebe plebe;
    private Construcciones construcciones;
    private Ejercito ejercito;
    private Castillo castillo;
    private int bolsaDeOro;
    private static final int oroInicial = 100;


    public Jugador(Mapa mapa) {
        this.mapa = mapa;
        this.plebe = new Plebe();
        this.construcciones = new Construcciones();
        this.ejercito = new Ejercito();
        this.condicionesIniciales();
    }

    private void condicionesIniciales() {
        this.bolsaDeOro = oroInicial;
        //if(!colocarPosicionablesEnPosicionA()) {
        //    colocarPosicionablesEnPosicionB();
        }

    private void colocarPosicionablesEnEsquinaInferiorIzquierda(){
        // plaza esta en arriba de castillo
        Posicion posPlazaCentral = new PosicionCuadrado(0,6,1,5);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());
        this.mapa.posicionar(plazaCentral);

        // castillo en la esquina inferior izquierda
        Posicion posCastillo = new PosicionCuadrado(0,3,3,0);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,0,7);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,1,7);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,2,7);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        //
        this.castillo = castillo;
        this.construcciones.agregarEdificio(plazaCentral);

        this.plebe.agregar(aldeano1);
        this.plebe.agregar(aldeano2);
        this.plebe.agregar(aldeano3);
    }

    private void colocarPosicionablesEnEsquinaSuperiorDerecha(){

        // plaza esta debajo del castillo
        Posicion posPlazaCentral = new PosicionCuadrado(27,15,28,14);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());

        // castillo en la esquina superior derecha
        Posicion posCastillo = new PosicionCuadrado(27,20,30,17);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,29,13);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,28,13);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,27,13);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(plazaCentral);
        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);


        this.castillo = castillo;
        this.construcciones.agregarEdificio(plazaCentral);

        this.plebe.agregar(aldeano1);
        this.plebe.agregar(aldeano2);
        this.plebe.agregar(aldeano3);
    }

    public void pagarCosto(int costo) {
        if (this.bolsaDeOro >= costo) {
            this.bolsaDeOro = this.bolsaDeOro - costo;
        }
        else{
            throw new OroInsuficienteException();
        }
    }


    public void ordenarRecolectarOro() {
        int oroRecolectado = this.plebe.trabajar();
        bolsaDeOro = (bolsaDeOro + oroRecolectado);
    }

    public void agregar(Edificio edificio) {
        this.construcciones.agregarEdificio(edificio);
    }

    public void agregar(Aldeano aldeano){
        this.plebe.agregar(aldeano);
    }

    public void agregar(UnidadMilitar unidadMilitar){
        this.ejercito.agregarUnidad(unidadMilitar);
    }

    public void esMio(Aldeano aldeano){
        this.plebe.incluyeA(aldeano);
    }

    public void esMio(UnidadMilitar unidadMilitar){
        this.ejercito.incluyeA(unidadMilitar);
    }

    public void esMio(Edificio edificio){
        this.construcciones.incluyeA(edificio);
    }

    public void recolectorDeCadaveres(){
        this.plebe.borrarCadaveres();
        this.ejercito.borrarCadaveres();
        this.construcciones.limpiarEscombros();
    }
}
