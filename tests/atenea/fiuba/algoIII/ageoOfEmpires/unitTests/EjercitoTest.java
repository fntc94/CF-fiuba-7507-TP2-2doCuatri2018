package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.edificios.EdificiosFabrica;
import modelo.edificios.IUnidadesPlazaCentralFabrica;
import modelo.unidades.Ejercito;
import modelo.unidades.UnidadMilitar;
import modelo.unidades.UnidadesFabrica;
import org.junit.Assert;
import org.junit.Test;

public class EjercitoTest {

    @Test
    public void pruebaTest(){
        Ejercito ejercito = new Ejercito();

        ejercito.agregarUnidad(new EdificiosFabrica().crearCastillo().crearArmaDeAsedio());

    }

}
