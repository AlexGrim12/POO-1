public class Enteros extends Racionales {
    private int valor;

    public Enteros(){
        super();
    }
    
    public Enteros(int valor){
        super();
        this.valor = valor;
    }

    public int getValorE(){
        return valor;
    }

    public void setValorE(int valor){
        this.valor = valor;
    }

    @Override
    public boolean pertenece(){
        return this instanceof Enteros;
    }

    @Override
    public String elementoIdentico(){
        return "0";
    }

    @Override
    public String inversoAditivo(){
        return "" + (-valor);
    }

    @Override
    public String inversoMultiplicativo(){
        return (this.valor == 1) ? "1" : "No existe inverso multiplicativo";
    }
    
    @Override
    public String toString(){
        return "Enteros";
    }
}
