public class Complejos {
    private double parteReal;
    private double parteImaginaria;

    public Complejos() {}

    public Complejos(double parteReal, double parteImaginaria) {
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

    public boolean pertenece() {
        return this instanceof Complejos;
    }

    public String elementoIdentico() {
        return "0.0";
    }

    public String inversoAditivo() {
        return "(" + (-parteReal) + ", " + (-parteImaginaria) + ")";
    }

    public String inversoMultiplicativo() {
        return "(" + (parteReal / 
        (parteReal * parteReal + parteImaginaria * parteImaginaria)) 
        + ", " + 
        (-parteImaginaria / 
        (parteReal * parteReal + parteImaginaria * parteImaginaria)) + ")";
    }

    public String toString() {
        return "Complejos";
    }
}
