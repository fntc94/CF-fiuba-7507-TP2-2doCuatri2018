package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Aldeanos implements Iterable<Aldeano> {

    private ArrayList<Aldeano> aldeanos = new ArrayList<>();

    public void agregar(Aldeano aldeano) {
        this.aldeanos.add(aldeano);
    }

    public int trabajar() {

        int oro = 0;
        for (Aldeano aldeano: this.aldeanos){
            oro += aldeano.trabajar();
        }

        return oro;
    }

    public boolean tieneAldeanos(){
        return this.aldeanos.size() > 0;
    }

    public boolean noTieneAldeanos(){
        return !this.tieneAldeanos();
    }

    public int cantidad(){
        return this.aldeanos.size();
    }

    @Override
    public Iterator<Aldeano> iterator() {
        return this.aldeanos.iterator();
    }
}
