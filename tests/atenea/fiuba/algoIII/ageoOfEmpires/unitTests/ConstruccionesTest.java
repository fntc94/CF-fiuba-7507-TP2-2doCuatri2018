package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.excepciones.EdificioNoEsPropioException;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;
import modelo.edificios.Construcciones;
import org.junit.Test;
import org.mockito.Mockito;


public class ConstruccionesTest {

    @Test(expected = EdificioNoEsPropioException.class)
    public void siSeVerificaQueConstruccionesIncluyeAUnCuartelNoIncluidoDebeLanzarEdificioNoPropioExceptionTest() {
        Construcciones construcciones = new Construcciones();
        Cuartel cuartel = Mockito.mock(Cuartel.class);
        construcciones.incluyeA(cuartel);
    }

    @Test(expected = EdificioNoEsPropioException.class)
    public void siSeVerificaQueConstruccionesIncluyeAUnaPlazaCentralNoIncluidoDebeLanzarEdificioNoPropioExceptionTest() {
        Construcciones construcciones = new Construcciones();
        PlazaCentral plazaCentral = Mockito.mock(PlazaCentral.class);
        construcciones.incluyeA(plazaCentral);
    }

    @Test(expected = EdificioNoEsPropioException.class)
    public void siConstruccionesIncluyeAUnCuartelQueNoSigueEnPieLuegoDeLimpiarEscombrosEsteNoDebeIncluirseTest(){
        Construcciones construcciones = new Construcciones();
        Cuartel cuartel = Mockito.mock(Cuartel.class);
        Mockito.when(cuartel.sigueEnPie()).thenReturn(false);
        construcciones.agregarEdificio(cuartel);
        construcciones.limpiarEscombros();
        construcciones.incluyeA(cuartel);
    }

    @Test(expected = EdificioNoEsPropioException.class)
    public void siConstruccionesIncluyeAUnaPlazaCentralQueNoSigueEnPieLuegoDeLimpiarEscombrosEsteNoDebeIncluirseTest(){
        Construcciones construcciones = new Construcciones();
        PlazaCentral plazaCentral = Mockito.mock(PlazaCentral.class);
        Mockito.when(plazaCentral.sigueEnPie()).thenReturn(false);
        construcciones.agregarEdificio(plazaCentral);
        construcciones.limpiarEscombros();
        construcciones.incluyeA(plazaCentral);
    }
}
