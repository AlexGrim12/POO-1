public class Ficha {
    private int caraIzq;
    private int caraDer;
    private int suma;
    private boolean mula = false;

    public Ficha(int caraIzq, int caraDer) {
        this.caraIzq = caraIzq;
        this.caraDer = caraDer;
        this.suma = caraIzq + caraDer;
        if (caraIzq == caraDer)
            mula = true;
    }

    public int getCaraIzq() {
        return caraIzq;
    }

    public int getCaraDer() {
        return caraDer;
    }

    public int getSuma() {
        return suma;
    }

    public boolean esMula() {
        return mula;
    }

    public void girar() {
        int aux = caraIzq;
        caraIzq = caraDer;
        caraDer = aux;
    }

    public String toString() {
        return "[" + caraIzq + "|" + caraDer + "]";
    }
}