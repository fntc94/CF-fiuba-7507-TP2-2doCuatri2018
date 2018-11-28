package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.juego.Jugador;
import modelo.ListaCircular;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;


public class ListaCircularTest {

    private Jugador jugador = Mockito.mock(Jugador.class);
    private Jugador jugador2 = Mockito.mock(Jugador.class);

    @Test
    public  void unaListaDeUnUnicoElementoDebeDevolverComoSiguienteASiMismoTest(){
        ListaCircular listaCircular = new ListaCircular();
        listaCircular.add(jugador);
        Assert.assertEquals(listaCircular.getSiguiente(), jugador);

    }

    @Test
    public void siAUnaListaCircularLeAgrego2ElementosYAvanzo2vecesMeDebeDevolverElPrimeroTest(){
        ListaCircular listaCircular = new ListaCircular();
        listaCircular.add(jugador);
        listaCircular.addLast(jugador2);
        Assert.assertNotEquals(jugador , jugador2); //verifica son dos jugadores diferentes
        Assert.assertEquals(listaCircular.getFirst(), jugador);
        Assert.assertEquals(listaCircular.getSiguiente(), jugador2);
        Assert.assertEquals(listaCircular.getSiguiente(), jugador);

    }

}
