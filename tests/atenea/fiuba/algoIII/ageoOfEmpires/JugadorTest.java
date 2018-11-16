package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

    @Test
   public void crearJugadorConPlazaCentral(){
        Jugador jugador = new Jugador();
        assertEquals(450, jugador.tienePlazaCentral());
   }

    @Test
    public void crearJugadorConCuartel(){
        Jugador jugador = new Jugador();
        assertEquals(450, jugador.tienePlazaCentral());
    }


}
