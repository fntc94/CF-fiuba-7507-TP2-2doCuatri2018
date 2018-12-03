package modelo.movimiento;

public class Direccion {

    private static IDireccion izquierdaArriba;
    private static IDireccion arriba;
    private static IDireccion derechaArriba;
    private static IDireccion izquierda;
    private static IDireccion derecha;
    private static IDireccion izquierdaAbajo;
    private static IDireccion abajo;
    private static IDireccion derechaAbajo;

    static {
        izquierdaArriba = new IzquierdaArriba();
        arriba = new Arriba();
        derechaArriba = new DerechaArriba();
        izquierda = new Izquierda();
        derecha = new Derecha();
        izquierdaAbajo = new IzquierdaAbajo();
        abajo = new Abajo();
        derechaAbajo = new DerechaAbajo();

    }

    public static IDireccion izquierdaArriba(){
        return izquierdaArriba;
    }

    public static IDireccion arriba(){
        return arriba;
    }

    public static IDireccion derechaArriba(){
        return derechaArriba;
    }

    public static IDireccion izquierda(){
        return izquierda;
    }

    public static IDireccion derecha(){
        return derecha;
    }

    public static IDireccion izquierdaAbajo(){
        return izquierdaAbajo;
    }

    public static IDireccion abajo(){
        return abajo;
    }

    public static IDireccion derechaAbajo(){
        return derechaAbajo;
    }
}
