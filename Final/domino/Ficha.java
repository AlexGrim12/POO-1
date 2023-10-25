package domino;

public class Ficha {
    // Atributos
    private int caraIzq;
    private int caraDer;
    private int suma;
    private boolean mula = false;

    // Metodo constructor
    public Ficha(int caraIzq, int caraDer) {
        this.caraIzq = caraIzq;
        this.caraDer = caraDer;
        this.suma = caraIzq + caraDer;
        if (caraIzq == caraDer)
            mula = true;
    }

    // Metodos getters
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

    // Cambia la cara izquierda por la derecha y viceversa
    public void girar() {
        int aux = caraIzq;
        caraIzq = caraDer;
        caraDer = aux;
    }

    // Imprime la ficha con el formato [caraIzq|caraDer]
    public String toString() {
        return "[" + caraIzq + "|" + caraDer + "]";
    }
}