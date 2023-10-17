public class Reales extends Complejos {
    private double valor;

    public Reales() {
        super();
    }

    public Reales(double valor) {
        super();
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean pertenece() {
        return this instanceof Reales;
    }

    @Override
    public String elementoIdentico() {
        return "0.0";
    }

    @Override
    public String inversoAditivo() {
        return "" + (-valor);
    }

    @Override
    public String inversoMultiplicativo() {
        return "" + (1 / valor);
    }

    @Override
    public String toString() {
        return "Reales";
    }
}