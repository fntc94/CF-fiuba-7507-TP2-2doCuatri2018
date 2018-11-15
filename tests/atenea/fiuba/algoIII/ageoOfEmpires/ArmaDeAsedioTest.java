package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArmaDeAsedioTest {

    @Test
    public  void alCrearseLaVidaDebeSerDe150(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        assertEquals(150, armaDeAsedio.getVida());
    }

    @Test
    public  void elCostoDeUnArmaDeAsedioDebeSer200(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        assertEquals(200, armaDeAsedio.getCosto());

    }

}
