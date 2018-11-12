package atenea.fiuba.algoIII.ageoOfEmpires;

public class Posicion {
    private int ejeX;
    private int ejeY;

    public Posicion(int x, int y){
        this.ejeX = x;
        this.ejeY = y;
    }

    public int getEjeX(){
        return this.ejeX;
    }

    public int getEjeY(){
        return this.ejeY;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Posicion other = (Posicion) obj;

        return (this.getEjeX() == other.getEjeX() && this.getEjeY() == other.getEjeY());
    }
}
