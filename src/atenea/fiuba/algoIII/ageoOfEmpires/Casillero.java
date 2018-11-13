package atenea.fiuba.algoIII.ageoOfEmpires;

public class Casillero {
    private int ejeX;
    private int ejeY;

    public Casillero(int x, int y) {
        this.ejeX = x;
        this.ejeY = y;
    }

    public int getEjeX() {
        return this.ejeX;
    }

    public int getEjeY(){
        return this.ejeY;
    }

    @Override
    public boolean equals(Object obj) {
        //Si me pasan algo que no sea un casillero va a ser diferente
        if (!(obj instanceof Casillero)) {
            return false;
        }
        //Si comparo a un casillero consigo mismo va a ser igual
        if (obj == this) {
            return true;
        }
        //Casteo el tipo Object

        Casillero other = (Casillero) obj;

        return (this.ejeX == other.getEjeX() && this.ejeY == other.getEjeY());
    }
}
