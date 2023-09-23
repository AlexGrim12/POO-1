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
        String winner = null;

        System.out.println("Bienvenido Tic Tac Toe 5x5");

        while (winner == null) {
            t.printBoard();
            int move;
            if (playerX.symbol.equals("X")) {
                move = playerX.makeMove();
            } else {
                move = playerO.makeMove();
            }

            if (move >= 1 && move <= 25 && board[move - 1].equals(String.valueOf(move))) {
                board[move - 1] = playerX.symbol.equals("X") ? "X" : "O";
            } else {
                System.out.println("Movimiento inválido. Inténtalo de nuevo.");
                continue;
            }

            winner = t.checkWinner();

            if (playerX.symbol.equals("X")) {
                playerX = playerO;
                playerO = new HumanPlayer("O");
            } else {
                playerX = playerO;
                playerO = new HumanPlayer("X");
            }
        }

        t.printBoard();

        if (winner.equals("Empate")) {
            System.out.println("Es un empate!");
        } else {
            System.out.println("¡El ganador es " + winner + "!");
        }
    }
}
