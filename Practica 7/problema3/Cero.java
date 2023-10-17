public final class Cero extends Enteros {
    final int valor = 0;

    public Cero() {
        super();
    }

    public int getValorC() {
        return valor;
    }

    @Override
    public boolean pertenece() {
        return this instanceof Cero;
    }

    @Override
    public String elementoIdentico() {
        return "0";
    }

    @Override
    public String inversoAditivo() {
        return "0";
    }

    @Override
    public String inversoMultiplicativo() {
        return "No existe inverso multiplicativo";
    }

    @Override
    public String toString() {
        return "Cero";
    }    
}
