public class Naturales extends Enteros {
    private int valor;

    public Naturales() {
        super();
    }

    public Naturales(int valor) {
        super();
        this.valor = valor;
    }

    public int getValorN() {
        return valor;
    }

    public void setValorN(int valor) {
        this.valor = valor;
    }

    @Override
    public boolean pertenece() {
        return this instanceof Naturales;
    }

    @Override
    public String elementoIdentico() {
        return "1";
    }

    @Override
    public String inversoAditivo() {
        return "No existe inverso aditivo";
    }

    @Override
    public String inversoMultiplicativo() {
        return (this.valor == 1) ? "1" : "No existe inverso multiplicativo";
    }

    @Override
    public String toString() {
        return "Naturales";
    }    
}
