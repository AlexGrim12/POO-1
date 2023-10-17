public final class Imaginarios extends Complejos{
    private double parteReal;
    private double parteImaginaria;

    public Imaginarios() {
        super();
    }

    public Imaginarios(double parteReal, double parteImaginaria) {
        super();
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    @Override
    public boolean pertenece() {
        return this instanceof Imaginarios;
    }

    @Override
    public String elementoIdentico() {
        return "0.0";
    }

    @Override
    public String inversoAditivo() {
        return "(" + (-parteReal) + ", " + (-parteImaginaria) + ")";
    }

    @Override
    public String inversoMultiplicativo() {
        return "(" + (parteReal / 
        (parteReal * parteReal + parteImaginaria * parteImaginaria)) 
        + ", " + 
        (-parteImaginaria / 
        (parteReal * parteReal + parteImaginaria * parteImaginaria)) + ")";
    }

    @Override
    public String toString() {
        return "Imaginarios";
    }
}
