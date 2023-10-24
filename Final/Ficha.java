public class Ficha {
    private int caraIzq;
    private int caraDer;
    private int suma;

    public Ficha(int caraIzq, int caraDer) {
        this.caraIzq = caraIzq;
        this.caraDer = caraDer;
        this.suma = caraIzq + caraDer;
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

    public void girar() {
        int aux = caraIzq;
        caraIzq = caraDer;
        caraDer = aux;
    }

    public String toString() {
        return "[" + caraIzq + "|" + caraDer + "]";
    }
}