package problema2;

public class Vehiculo {
    private String numSerie = "";

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String a) {
        this.numSerie = a;
    }

    @Override

    public String toString() {
        return "Vehiculo{" + "numSerie=" + numSerie + '}';
    }
}