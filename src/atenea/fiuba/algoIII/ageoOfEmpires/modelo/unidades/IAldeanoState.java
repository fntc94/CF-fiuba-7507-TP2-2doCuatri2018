package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

public interface IAldeanoState extends IEstadoReparador {

    boolean estaRecolectandoOro();
    int recolectarOro();

    boolean estaConstruyendo();
    void construir();

}
