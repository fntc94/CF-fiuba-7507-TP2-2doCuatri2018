package atenea.fiuba.algoIII.ageoOfEmpires;

public class PosicionCuadrado extends Posicion {

    //Cada uno de los parametros representa una esquina
    public PosicionCuadrado(int arr_derx, int arr_dery , int arr_izx, int arr_izy, int ab_derx, int ab_dery, int ab_izx, int ab_izy) {
        super();

        //Agrego los casilleros ocupados
        for(int j = arr_dery; j >= ab_dery; j--)
            for(int i = arr_derx; i <= arr_izx; i++)
                this.posicionesOcupadas.add(new Casillero(i, j));
    }
}
