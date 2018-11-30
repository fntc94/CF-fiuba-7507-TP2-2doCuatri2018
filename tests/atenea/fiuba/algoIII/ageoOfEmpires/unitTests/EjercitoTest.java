package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.excepciones.UnidadNoEsPropiaException;
import modelo.unidades.Espadachin;
import modelo.unidades.Arquero;
import modelo.unidades.Ejercito;
import modelo.unidades.ArmaDeAsedio;
import org.junit.Test;
import org.mockito.Mockito;

public class EjercitoTest {

    @Test(expected = UnidadNoEsPropiaException.class)
    public void siEjercitoIncluyeAUnEspadachinMuertaLuegoDeBorrarCadaveresEstaNoDebeIncluirseTest(){
        Ejercito ejercito = new Ejercito();
        Espadachin espadachin = Mockito.mock(Espadachin.class);
        Mockito.when(espadachin.estaMuerto()).thenReturn(true);
        ejercito.agregarUnidad(espadachin);
        ejercito.borrarCadaveres();
        ejercito.incluyeA(espadachin);
    }

    @Test(expected = UnidadNoEsPropiaException.class)
    public void siEjercitoIncluyeAUnArqueroMuertoLuegoDeBorrarCadaveresEstaNoDebeIncluirseTest(){
        Ejercito ejercito = new Ejercito();
        Arquero arquero = Mockito.mock(Arquero.class);
        Mockito.when(arquero.estaMuerto()).thenReturn(true);
        ejercito.agregarUnidad(arquero);
        ejercito.borrarCadaveres();
        ejercito.incluyeA(arquero);
    }

    @Test(expected = UnidadNoEsPropiaException.class)
    public void siEjercitoIncluyeAUnArmaDeAsedioMuertaLuegoDeBorrarCadaveresEstaNoDebeIncluirseTest(){
        Ejercito ejercito = new Ejercito();
        ArmaDeAsedio armaDeAsedio = Mockito.mock(ArmaDeAsedio.class);
        Mockito.when(armaDeAsedio.estaMuerto()).thenReturn(true);
        ejercito.agregarUnidad(armaDeAsedio);
        ejercito.borrarCadaveres();
        ejercito.incluyeA(armaDeAsedio);
    }
}
