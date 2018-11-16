package atenea.fiuba.algoIII.ageoOfEmpires;

public class Jugador {
    private Castillo castillo;
    private PlazaCentral plazaCentral;
    private Cuartel cuartel;
    private EdificiosFabrica edificiosFabrica;
    private EdificiosEnConstruccionFabrica edificiosEnConstruccionFabrica;
    private EdificioEnConstruccion edificioEnConstruccion;

    public Jugador (){
        this.edificiosFabrica = new EdificiosFabrica();
        this.castillo = edificiosFabrica.crearCastillo();
        this.plazaCentral = edificiosFabrica.crearPlazaCentral();
        this.edificiosEnConstruccionFabrica = new EdificiosEnConstruccionFabrica();
    }

    public boolean tienePlazaCentral(){
        return this.edificioEnConstruccion.estaTerminado();
    }

    public boolean tieneCuartel(){
        return this.edificioEnConstruccion.estaTerminado();
    }

    public void inicializarCuartel(){
        this.edificioEnConstruccion = this.edificiosEnConstruccionFabrica.obtenerCuartelEnConstruccion();
    }

    public void inicializarPlazaCentral(){
        this.edificioEnConstruccion = this.edificiosEnConstruccionFabrica.obtenerPlazaCentralEnConstruccion();
    }

    public void avanzarConstruccion(){
        this.edificioEnConstruccion.avanzarConstruccion();
    }

    public void obtenerEdificioTerminado(){
        this.cuartel = edificiosFabrica.crearCuartel();
    }








}
