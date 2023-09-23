interface Board {
    String checkWinner();
    void printBoard();
}

public class TicTacToe implements Board {
    private static String[] board = new String[25];
    private static HumanPlayer playerX = new HumanPlayer("X");
    private static HumanPlayer playerO = new HumanPlayer("O");

    public TicTacToe() {
        for (int i = 0; i < 25; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    public String checkWinner() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j + 3 < 5) {
                    if (board[i * 5 + j].equals(board[i * 5 + j + 1]) &&
                        board[i * 5 + j].equals(board[i * 5 + j + 2]) &&
                        board[i * 5 + j].equals(board[i * 5 + j + 3])) {
                        return board[i * 5 + j];
                    }
                }
                if (i + 3 < 5) {
                    if (board[i * 5 + j].equals(board[(i + 1) * 5 + j]) &&
                        board[i * 5 + j].equals(board[(i + 2) * 5 + j]) &&
                        board[i * 5 + j].equals(board[(i + 3) * 5 + j])) {
                        return board[i * 5 + j];
                    }
                }
                if (i + 3 < 5 && j + 3 < 5) {
                    if (board[i * 5 + j].equals(board[(i + 1) * 5 + j + 1]) &&
                        board[i * 5 + j].equals(board[(i + 2) * 5 + j + 2]) &&
                        board[i * 5 + j].equals(board[(i + 3) * 5 + j + 3])) {
                        return board[i * 5 + j];
                    }
                }
                if (i + 3 < 5 && j - 3 >= 0) {
                    if (board[i * 5 + j].equals(board[(i + 1) * 5 + j - 1]) &&
                        board[i * 5 + j].equals(board[(i + 2) * 5 + j - 2]) &&
                        board[i * 5 + j].equals(board[(i + 3) * 5 + j - 3])) {
                        return board[i * 5 + j];
                    }
                }
            }
        }

        for(int i = 0; i < 25; i++) {
            if (board[i].equals(String.valueOf(i + 1))) {
                return null;
            } 
        }

        return "Empate";
    }

    public void printBoard() {
        System.out.println("\nTablero actual:");
        for (int i = 0; i < 25; i++) {
            System.out.print("| " + board[i] + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println("|");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        int turno = 1;
        String jugadorActual = "X";
        String winner = null;

        System.out.println("Bienvenido Tic Tac Toe 5x5");

        while (winner == null) {
            t.printBoard();
            int move;

            do {
                if (turno % 2 == 1) {
                    move = playerX.makeMove();
                    jugadorActual = playerX.symbol;
                } else {
                    move = playerO.makeMove();
                    jugadorActual = playerO.symbol;
                }
                
                if (move < 1 && move > 25 && !board[move - 1].equals(String.valueOf(move))) {
                    System.out.println("Movimiento inválido. Inténtalo de nuevo.");
                } else {
                    board[move - 1] = jugadorActual;
                    turno++;
                    break;
                }
            } while(true);

            winner = t.checkWinner();
        }

        if (winner.equals("Empate")) {
            System.out.println("Es un empate!");
        } else {
            System.out.println("¡El ganador es " + winner + "!");
        }
    }
}
