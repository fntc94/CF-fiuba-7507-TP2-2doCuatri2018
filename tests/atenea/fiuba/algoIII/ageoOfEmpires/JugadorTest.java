package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
    public void creaUnJugadorConRecursosBasicosTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        Assert.assertTrue(jugador.tienePlazaCentral());
        Assert.assertTrue(jugador.tieneOro(90));
    }

    @Test
    public void creaJugadorOrdenaAUnAldeanoARecolectarOroTestYOroAumentaEn20(){
        Jugador jugador = new Jugador();
        Assert.assertFalse(jugador.tieneOro(120));
        jugador.ordenarRecolectarOro();
        Assert.assertTrue(jugador.tieneOro(120));

    }


}
