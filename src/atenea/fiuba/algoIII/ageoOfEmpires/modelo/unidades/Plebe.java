package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.UnidadNoEsPropiaException;

import java.util.LinkedList;

public class Plebe {

    private LinkedList<Aldeano> aldeanos;

    public Plebe(){
        this.aldeanos = new LinkedList<>();
    }

    public void agregarAldeano(Aldeano aldeano){
        this.aldeanos.addLast(aldeano);
    }

    public void incluyeA(Aldeano aldeano){
        if (! (this.aldeanos.contains(aldeano))){
            throw new UnidadNoEsPropiaException();
        }
    }

    public  boolean cantidad(int cantidad){
        return (this.aldeanos.size() == cantidad);
    }

    public int trabajar(){
        int oroRecolectado = 0;
        for (Aldeano aldeano : this.aldeanos) {
            oroRecolectado = oroRecolectado + aldeano.trabajar();
        }
        return oroRecolectado;
    }
}
