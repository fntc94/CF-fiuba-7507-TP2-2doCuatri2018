package modelo;

import java.util.LinkedList;

public class ListaCircular<Jugador> extends LinkedList<Jugador> {

    private int posicionActual = 0;

    public Jugador getSiguiente(){
        if (posicionActual<= this.size()){
            posicionActual = posicionActual + 1;
            return this.get(posicionActual);
        }
        else {
            posicionActual = 0;
            return this.getFirst();
        }
    }
}
