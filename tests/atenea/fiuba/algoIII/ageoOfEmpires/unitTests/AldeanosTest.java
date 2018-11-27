package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.IEdificioReparable;
import modelo.edificios.IUnidadesPlazaCentralFabrica;
import modelo.unidades.Aldeano;
import modelo.unidades.Aldeanos;
import modelo.unidades.UnidadesFabrica;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AldeanosTest {

    private IUnidadesPlazaCentralFabrica unidadesPlazaCentralFabrica = new UnidadesFabrica();

    @Test
    public void trabajar_TresAldeanosRecolectando_Devuelve60(){


        // Arrange
        Aldeanos aldeanos = new Aldeanos();
        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();

        aldeanos.agregar(aldeano1);
        aldeanos.agregar(aldeano2);
        aldeanos.agregar(aldeano3);

        int oroEsperado = 60;

        // Act
        int oroRecolectado = aldeanos.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

//    @Test
//    public void trabajar_DosAldeanosRecolectandoYUnoConstruyendo_Devuelve40(){
//
//
//        // Arrange
//        Aldeanos aldeanos = new Aldeanos();
//        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();
//
//        aldeanos.agregar(aldeano1);
//        aldeanos.agregar(aldeano2);
//        aldeanos.agregar(aldeano3);
//
//
//        aldeano3.iniciarConstruccionDeCuartel();
//        int oroEsperado = 40;
//
//        // Act
//        int oroRecolectado = aldeanos.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//    }

//    @Test
//    public void trabajar_UnAldeanoRecolectandoYDosConstruyendo_Devuelve20(){
//
//
//        // Arrange
//        Aldeanos aldeanos = new Aldeanos();
//        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();
//
//        aldeanos.agregar(aldeano1);
//        aldeanos.agregar(aldeano2);
//        aldeanos.agregar(aldeano3);
//
//        aldeano2.iniciarConstruccionDeCuartel();
//        aldeano3.iniciarConstruccionDePlazaCentral();
//        int oroEsperado = 20;
//
//        // Act
//        int oroRecolectado = aldeanos.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//    }

    @Test
    public void trabajar_DosAldeanosRecolectandoYUnoReparando_Devuelve40(){


        // Arrange
        Aldeanos aldeanos = new Aldeanos();
        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();

        aldeanos.agregar(aldeano1);
        aldeanos.agregar(aldeano2);
        aldeanos.agregar(aldeano3);


        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);
        aldeano3.iniciarReparacion(edificioReparable);
        int oroEsperado = 40;

        // Act
        int oroRecolectado = aldeanos.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void trabajar_UnAldeanoRecolectandoYDosReparando_Devuelve20(){


        // Arrange
        Aldeanos aldeanos = new Aldeanos();
        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();

        aldeanos.agregar(aldeano1);
        aldeanos.agregar(aldeano2);
        aldeanos.agregar(aldeano3);

        IEdificioReparable edificio1 = Mockito.mock(IEdificioReparable.class);
        aldeano1.iniciarReparacion(edificio1);

        IEdificioReparable edificio2 = Mockito.mock(IEdificioReparable.class);
        aldeano2.iniciarReparacion(edificio2);
        int oroEsperado = 20;

        // Act
        int oroRecolectado = aldeanos.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

//    @Test
//    public void trabajar_UnAldeanoRecolectandoOtroConstruyendoYOtroReparando_Devuelve20(){
//
//
//        // Arrange
//        Aldeanos aldeanos = new Aldeanos();
//        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();
//
//        aldeanos.agregar(aldeano1);
//        aldeanos.agregar(aldeano2);
//        aldeanos.agregar(aldeano3);
//
//        aldeano1.iniciarConstruccionDeCuartel();
//
//        IEdificioReparable edificio = Mockito.mock(IEdificioReparable.class);
//        aldeano2.iniciarReparacion(edificio);
//        int oroEsperado = 20;
//
//        // Act
//        int oroRecolectado = aldeanos.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//    }

//    @Test
//    public void trabajar_TresAldeanosRecolectandoYUnoConstruyendo_AntesDeTerminarLaConstruccionDevuelve40(){
//
//        // Arrange
//        Aldeanos aldeanos = new Aldeanos();
//        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();
//
//        aldeanos.agregar(aldeano1);
//        aldeanos.agregar(aldeano2);
//        aldeanos.agregar(aldeano3);
//
//        // la construcción de la plaza central se termina en tres turnos
//        aldeano1.iniciarConstruccionDePlazaCentral();
//        aldeano1.trabajar();
//
//        int oroEsperado = 40;
//
//        // Act
//        int oroRecolectado = aldeanos.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//    }

//    @Test
//    public void trabajar_TresAldeanosRecolectandoYUnoConstruyendo_AlTerminarLaConstruccionDevuelve60(){
//
//
//        // Arrange
//        Aldeanos aldeanos = new Aldeanos();
//        Aldeano aldeano1 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano2 = unidadesPlazaCentralFabrica.crearAldeano();
//        Aldeano aldeano3 = unidadesPlazaCentralFabrica.crearAldeano();
//
//        aldeanos.agregar(aldeano1);
//        aldeanos.agregar(aldeano2);
//        aldeanos.agregar(aldeano3);
//
//        // la construcción de la plaza central se termina en tres turnos
//        aldeano1.iniciarConstruccionDePlazaCentral();
//        aldeano1.trabajar();
//        aldeano1.trabajar();
//
//        int oroEsperado = 60;
//
//        // Act
//        int oroRecolectado = aldeanos.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//    }


}
