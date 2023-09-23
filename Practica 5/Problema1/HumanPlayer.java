import java.util.*;

abstract class Player {
    protected String symbol;

    public abstract void setSymbol(String symbol);
    public abstract int makeMove();
}

class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String symbol) {
        setSymbol(symbol);
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int makeMove() {
        System.out.print("Es el turno de " + this.symbol);
        System.out.print(". Ingresa un numero del 1 al 25: ");
        int move = scanner.nextInt();
        return move;
    }
}
