package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private Castillo castillo;
    private List<PlazaCentral> plazas;
    private List<Cuartel> cuarteles;
    private List<Aldeano> aldeanos;
    private List<ArmaDeAsedio> armas;
    private List<Arquero> arqueros;
    private List<Espadachin> espadachines;
    private int bolsaDeOro;
    private static final int  oroInicial = 100;


    public Jugador (){
      this.plazas = new ArrayList<PlazaCentral>();
      this.cuarteles = new ArrayList<Cuartel>();
      this.aldeanos = new ArrayList<Aldeano>();
      this.armas = new ArrayList<ArmaDeAsedio>();
      this.arqueros = new ArrayList<Arquero>();
      this.espadachines = new ArrayList<Espadachin>();
      this.castillo = new EdificiosFabrica().crearCastillo();
      this.bolsaDeOro = 0;
      this.recursosBasicos();
    }

    private void recursosBasicos(){
        this.bolsaDeOro = this.oroInicial;
        this.plazas.add(new EdificiosFabrica().crearPlazaCentral());
        for(int cantidad = 1; cantidad<=3;cantidad++){
            Aldeano aldeano = this.plazas.get(0).construirAldeano();
            this.aldeanos.add(aldeano);
        }
    }
    
    public boolean tieneAldeanos(int cantidad){
        return (cantidad <= this.aldeanos.size());
    }

    public boolean tienePlazaCentral(){
        return (this.aldeanos.size() >= 1);
    }

    public boolean tieneOro(int cantidad){
        return (this.bolsaDeOro >= cantidad );

    }

    public void ordenarRecolectarOro(){
        for (Aldeano aldeano: this.aldeanos) {
            this.bolsaDeOro += aldeano.recolectarOro();
        }
    }










}
