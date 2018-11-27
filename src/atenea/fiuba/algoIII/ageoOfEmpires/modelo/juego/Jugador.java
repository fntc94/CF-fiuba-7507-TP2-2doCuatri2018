package atenea.fiuba.algoIII.ageoOfEmpires.modelo.juego;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Castillo;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificiosFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Plebe;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Ejercito;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.UnidadMilitar;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Construcciones;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.PlazaCentral;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OroInsuficienteException;

public class Jugador {
    private Plebe plebe;
    private Construcciones construcciones;
    private Ejercito ejercito;
    private Castillo castillo;
    private int bolsaDeOro;
    private static final int oroInicial = 100;


    public Jugador() {

        this.plebe = new Plebe();
        this.construcciones = new Construcciones();
        this.ejercito = new Ejercito();
        this.condicionesIniciales();
    }

    private void condicionesIniciales() {

        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        for (int i = 0; i < 3; i++) {
            plebe.agregarAldeano(plazaCentral.construirAldeano());
        }
        this.castillo = new EdificiosFabrica().crearCastillo();
        this.construcciones.agregarEdificio(plazaCentral);
        this.bolsaDeOro = oroInicial;
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


    public void agregarEdificio(Edificio edificio) {
        this.construcciones.agregarEdificio(edificio);
    }

    public void agregarAldeano(Aldeano aldeano){
        this.plebe.agregarAldeano(aldeano);
    }

    public void agregarUnidadMilitar(UnidadMilitar unidadMilitar){
        this.ejercito.agregarUnidad(unidadMilitar);
    }


    /*
    //SUJETO A VERIFICACION ! ! ! ! ! ! ! ! ! ! !
     public void actualizarVidaDePosicionables(){
        this.ejercito.actualizarVidaDeUnidadesMilitares();
        this.plebe.actualizarVidaDeAldeanos();
        this.construcciones.actualizarVidaDeEdificios();
        this.castillo.actualizarVidaDelCastillo();
    }
    */
}