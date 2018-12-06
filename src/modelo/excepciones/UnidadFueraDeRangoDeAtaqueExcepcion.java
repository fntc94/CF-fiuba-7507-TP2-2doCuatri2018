package modelo.excepciones;

public class UnidadFueraDeRangoDeAtaqueExcepcion extends RuntimeException {

    @Override
    public String getMessage(){
       return "Unidad fuera del rango de ataque";
    }
}
