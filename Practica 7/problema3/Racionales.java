public class Racionales extends Reales{
    private double valor;

    public Racionales(){
        super();
    }

    public Racionales(double valor){
        super();
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }
    
    @Override
    public boolean pertenece(){
        return this instanceof Racionales;
    }

    @Override
    public String elementoIdentico(){
        return "0.0";
    }

    @Override
    public String inversoAditivo(){
        return "" + (-valor);
    }

    @Override
    public String inversoMultiplicativo(){
        return "" + (1/valor);
    }
    
    @Override
    public String toString(){
        return "Racionales";
    }
}