public final class Irracionales extends Reales{
    private double valor;

    public Irracionales(){
        super();
    }

    public Irracionales(double valor){
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
        return this instanceof Irracionales;
    }

    @Override
    public String elementoIdentico(){
        return "No existe elemento identico";
    }

    @Override
    public String inversoAditivo(){
        return "No existe inverso aditivo";
    }

    @Override
    public String inversoMultiplicativo(){
        return "No existe inverso multiplicativo";
    }

    @Override
    public String toString(){
        return "Irracionales";
    }
}
