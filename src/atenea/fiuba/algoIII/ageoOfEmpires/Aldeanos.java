package atenea.fiuba.algoIII.ageoOfEmpires;

import atenea.fiuba.algoIII.ageoOfEmpires.Aldeano;

import java.util.LinkedList;

public class Aldeanos {

    private LinkedList<Aldeano> aldeanos;

    public Aldeanos(){
        this.aldeanos = new LinkedList<>();
    }

    public void trabajar(){
        int oroRecolectado = 0;
        for (Aldeano aldeano : this.aldeanos) {
            aldeano.continuarConstruyendo();
            aldeano.continuarReparando();
            oroRecolectado = oroRecolectado + aldeano.recolectarOro();
        }
    }

    public void iniciarConstruccionDePlazaCentral(){
    }

    public void iniciarConstruccionDeCuartel(){

    }

}
