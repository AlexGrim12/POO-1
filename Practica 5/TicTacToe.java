import java.util.*;

interface Board {
    String checkWinner();   
    void printBoard();
} 

// tarea practica
// asbtrac class Player {}

abstract class Player {

}

public class TicTacToe implements Board {
    static String[] board;
    static String Player;

    //override
    public String checkWinner() {
        for(int i = 0; i < 8; i ++) {
            String line = null;

            switch(i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            // si gana jugador X
            if(line.equals("XXX"))
                return "X";
            // si gana jugador O
            else if(line.equals("OOO"))
                return "O";
        } 

        for(int a = 0; a < 9; a ++) {
            if(Arrays.asList(board).contains(String.valueOf(a + 1)))
                break;
            else if(a == 8)
                return "draw";
        }
    }

    System.out.println("es el turno de: " + player + "; ingrese un numero del 1 al 9");
    return null;
} 

// imprimir
/*
|---|---|---|
| 1 | 2 | 3 |
|---|---|---|
| 4 | 5 | 6 |
|---|---|---|
| 7 | 8 | 9 |
|---|---|---|
*/

static void printBoard() {
    System.out.println("|---|---|---|");
    System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
    System.out.println("|---|---|---|");
    System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
    System.out.println("|---|---|---|");
    System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
    System.out.println("|---|---|---|");
}
