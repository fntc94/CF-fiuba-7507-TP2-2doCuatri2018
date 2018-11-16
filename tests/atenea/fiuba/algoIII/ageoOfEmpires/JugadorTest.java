package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
   public void crearJugadorConPlazaCentral(){
        Jugador jugador = new Jugador();
        jugador.inicializarPlazaCentral();
        Assert.assertFalse(jugador.tienePlazaCentral());
   }

    @Test
    public void crearJugadorContruyePlazaCentralPeroNoEstaTerminado(){
        Jugador jugador = new Jugador();
        jugador.inicializarCuartel();
        Assert.assertFalse( jugador.tieneCuartel());
    }

    @Test
    public void crearJugadorAvanzaEnLaConstruccionDeLaPlazaCentralNoEstaTerminado(){
        Jugador jugador = new Jugador();
        jugador.inicializarCuartel();
        Assert.assertFalse(jugador.tieneCuartel());
    }

    @Test
    public void crearJugadorAvanzaMuchoEnLaConstruccionDeLaPlazaCentralEstaTerminado(){
        Jugador jugador = new Jugador();
        jugador.inicializarPlazaCentral();
        jugador.avanzarConstruccion();
        jugador.avanzarConstruccion();
        jugador.avanzarConstruccion();
        Assert.assertTrue(jugador.tienePlazaCentral());
    }

    @Test
    public void crearJugadorContruyeCuartelPeroNoEstaTerminado(){
        Jugador jugador = new Jugador();
        jugador.inicializarCuartel();
        Assert.assertFalse( jugador.tieneCuartel());
    }

    @Test
    public void crearJugadorAvanzaEnLaConstruccionDelCuartelNoEstaTerminado(){
        Jugador jugador = new Jugador();
        jugador.inicializarCuartel();
        Assert.assertFalse(jugador.tieneCuartel());
    }

    @Test
    public void crearJugadorAvanzaMuchoEnLaConstruccionDelCuartelEstaTerminado(){
        Jugador jugador = new Jugador();
        jugador.inicializarCuartel();
        jugador.avanzarConstruccion();
        jugador.avanzarConstruccion();
        jugador.avanzarConstruccion();
        Assert.assertTrue(jugador.tieneCuartel());
    }

    @Test
    public void crearJugadorConstruyeCuartelYPlazaCentralNoEstanTerminadas(){
        Jugador jugador = new Jugador();
        jugador.inicializarCuartel();
        jugador.inicializarPlazaCentral();
        jugador.avanzarConstruccion();
        jugador.avanzarConstruccion();
        jugador.avanzarConstruccion();
        Assert.assertTrue(jugador.tieneCuartel());
        Assert.assertTrue(jugador.tienePlazaCentral());
    }

}
