package atenea.fiuba.algoIII.ageoOfEmpires;

public class ColeccionDePosisionables {

    private Ejercito ejercito;
    private Aldeanos aldeanos;
    private Edificios edificios;
    private EdificiosFabrica edificiosFabrica;

    public ColeccionDePosisionables(){
        this.aldeanos = new Aldeanos();
        this.ejercito = new Ejercito();
        this.edificios = new Edificios();
        this.edificiosFabrica = new EdificiosFabrica();
    }

    public void construirPlazaCentral(){
        this.aldeanos.iniciarConstruccionDePlazaCentral();
        this.aldeanos.trabajar();
        edificios.agregarEdificio(edificiosFabrica.crearPlazaCentral());
    }


}
