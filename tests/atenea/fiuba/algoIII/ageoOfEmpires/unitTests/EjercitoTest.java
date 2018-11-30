package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.excepciones.UnidadNoEsPropiaException;
import modelo.unidades.Espadachin;
import modelo.unidades.Arquero;
import modelo.unidades.Ejercito;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EjercitoTest {

    @Test(expected = UnidadNoEsPropiaException.class)
    public void siEjercitoIncluyeAUnaUnidadMilitarMuertaLuegoDeBorrarCadaveresEstaNoDebeIncluirseTest(){
        Ejercito ejercito = new Ejercito();
        Espadachin espadachin = Mockito.mock(Espadachin.class);
        Mockito.when(espadachin.estaMuerto()).thenReturn(true);
        ejercito.agregarUnidad(espadachin);
        ejercito.borrarCadaveres();
        ejercito.incluyeA(espadachin);
    }
}
