package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.*;

public class Jugador {
    private Castillo castillo;
    private List<PlazaCentral> plazas;
    private List<Cuartel> cuarteles;
    private LinkedList<Aldeano> aldeanos;
    private List<ArmaDeAsedio> armas;
    private List<Arquero> arqueros;
    private List<Espadachin> espadachines;
    private ColaDeConstruccion colaDeConstruccion;
    private int primerPosicion;
    private int bolsaDeOro;
    private static final int  oroInicial = 100;


    public Jugador (){
      this.plazas = new ArrayList<>();
      this.cuarteles = new ArrayList<>();
      this.aldeanos = new LinkedList<>();
      this.armas = new ArrayList<>();
      this.arqueros = new ArrayList<>();
      this.espadachines = new ArrayList<>();
      this.castillo = new EdificiosFabrica().crearCastillo();
      this.colaDeConstruccion = new ColaDeConstruccion();
      this.bolsaDeOro = 0;
      this.primerPosicion = 0;
      this.recursosBasicos();
    }

    private void recursosBasicos(){
        this.bolsaDeOro = oroInicial;
        this.plazas.add(new EdificiosFabrica().crearPlazaCentral());
        for(int cantidad = 1; cantidad<=3;cantidad++){
            Aldeano aldeano = this.plazas.get(this.primerPosicion).construirAldeano();
            this.aldeanos.add(aldeano);
        }
    }
    
    public boolean tieneAldeanos(int cantidad){
        return (cantidad <= this.aldeanos.size());
    }


    public boolean tieneOro(int cantidad){
        return (this.bolsaDeOro >= cantidad );

    }

    public int tieneCuarteles(){
        return (this.cuarteles.size() );
    }

    public int tienePlazas(){
        return (this.plazas.size() );
    }

    public void ordenarRecolectarOro(){
        for (Aldeano aldeano: this.aldeanos) {
            this.bolsaDeOro += aldeano.recolectarOro();
        }
    }

    public void ordenarIniciarConstruccionPlazaCentral(){
        if( this.aldeanos.isEmpty() ){
            throw new AldeanosOcupadosException();
        }
        else {
            Aldeano aldeano = this.aldeanos.remove();
            aldeano.iniciarConstruccionDePlazaCentral(plaza ->this.plazas.add(plaza));
            this.colaDeConstruccion.actualizarColaDeConstruccion(aldeano);
        }
    }

   public void ordenarAvanzarConstruccion(){
       try
       {
           this.colaDeConstruccion.avanzarConstruccion(aldeano ->this.aldeanos.add(aldeano));
       }
       catch (OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion ex){
           throw (new NoHayEdificiosEnConstruccionException());
       }

   }

   public void ordenarIniciarConstruccionCuartel(){
        if( this.aldeanos.isEmpty() ){
            throw new AldeanosOcupadosException();
        }
        else {
            Aldeano aldeano = this.aldeanos.remove();
            aldeano.iniciarConstruccionDeCuartel(cuartel ->this.cuarteles.add(cuartel));
            this.colaDeConstruccion.actualizarColaDeConstruccion(aldeano);
        }
    }

}
