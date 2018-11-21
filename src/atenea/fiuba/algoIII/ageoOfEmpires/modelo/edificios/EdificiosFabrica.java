package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.PosicionDeUnCasillero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.UnidadesFabrica;

public class EdificiosFabrica {

    private UnidadesFabrica fabricaDeUnidades = new UnidadesFabrica();
    private IEstrategiaAtaque<Castillo> estrategiaAtaqueCastillo = new EstrategiaAtaqueCastillo();

    //  ESTAS POSICIONES DEBERIAN RECIBIR UN MAPA. REVISAR

    public PlazaCentral crearPlazaCentral(){
        return new PlazaCentral(new PosicionDeUnCasillero(0,0), fabricaDeUnidades);
    }

    public Cuartel crearCuartel(){
        return new Cuartel(new PosicionDeUnCasillero(0,0), fabricaDeUnidades);
    }

    public Castillo crearCastillo(){
        return new Castillo(new PosicionDeUnCasillero(0,0), fabricaDeUnidades, estrategiaAtaqueCastillo);
    }

}
