public class EnterosNegativos extends Enteros{
    private int valor;

    public EnterosNegativos(){
        super();
    }

    public EnterosNegativos(int valor){
        super();
        this.valor = valor;
    }

    public int getValorEN(){
        return valor;
    }

    public void setValorEN(int valor){
        this.valor = valor;
    }
    
    @Override
    public boolean pertenece(){
        return this instanceof EnterosNegativos;
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
        return (this.valor == -1) ? "-1" : "No existe inverso multiplicativo";
    }

    @Override
    public String toString(){
        return "EnterosNegativos";
    }    
}
