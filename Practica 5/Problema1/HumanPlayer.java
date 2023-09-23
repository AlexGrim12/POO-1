import java.util.*;

abstract class Player {
    protected String symbol;

    public abstract void setSymbol(String symbol);
    public abstract int makeMove();
}

class HumanPlayer extends Player {
    public HumanPlayer(String symbol) {
        setSymbol(symbol);
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Es el turno de " + symbol + ". Ingresa un número del 1 al 25: ");
        int move = scanner.nextInt();
        scanner.close();
        return move;
    }
}
