package modelo;

import java.util.ArrayList;

public class ListaCircular<Jugador> extends ArrayList<Jugador> {

    public Jugador get(int index)
    {
        if (index == -1)
        {
            index = size()-1;
        }

        else if (index == size())
        {
            index = 0;
        }

        return super.get(index);
    }

}
