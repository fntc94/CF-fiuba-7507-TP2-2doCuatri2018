package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EspadachinTest{

    @Test
    public void alCrearseGetVidaDevuelve100(){
        Espadachin espadachin = new Espadachin();
        assertEquals (100, espadachin.getVida());

    }

    @Test
    public void alPreguntarElCostoDeUnEspadachinDebeDevolver50(){
        Espadachin espadachin = new Espadachin();
        assertEquals(50, espadachin.getCosto());
    }
}
