package modelo.juego;

import modelo.Edificio;
import modelo.edificios.*;
import modelo.excepciones.OroInsuficienteException;
import modelo.posicion.*;
import modelo.unidades.*;

public class Jugador {
    private Plebe plebe;
    private Construcciones construcciones;
    private Ejercito ejercito;
    private Castillo castillo;
    private int bolsaDeOro;
    private static final int oroInicial = 100;
    private String nombre;


    public Jugador(String nombre, Castillo castillo) {
        this.plebe = new Plebe();
        this.construcciones = new Construcciones();
        this.ejercito = new Ejercito();
        this.nombre = nombre;
        this.castillo = castillo;
        this.condicionesIniciales();
    }

    private void condicionesIniciales( ) {
        this.bolsaDeOro = oroInicial;

        int cantidad = 3;
        for(int i = 0; i < cantidad; i++){
            Aldeano aldeano = new UnidadesFabrica().crearAldeano();
            this.plebe.agregar(aldeano);
        }
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
        this.bolsaDeOro = (this.bolsaDeOro + oroRecolectado);
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

    public boolean castilloDestruido(){
        return !(this.castillo.sigueEnPie());
    }
}
