import java.util.*;

interface Board {
    // En interfaz por lo general los metodos son default
	String checkWinner();
	void printBoard();
}

public class TicTacToe implements Board {
	static String[] board;
	static String player; // Posible objeto que venga de la clase Player L11
    
	// Override
	public String checkWinner() {
		for(int i = 0;  i <8; i ++) {
			String line = null;
			switch(i) {
				case 0: line = board[0] + board[1] + board[2]; break;
				case 1: line = board[3] + board[4] + board[5]; break;
				case 2: line = board[6] + board[7] + board[8]; break;
				case 3: line = board[0] + board[3] + board[6]; break;
				case 4: line = board[1] + board[4] + board[7]; break;
				case 5: line = board[2] + board[5] + board[8]; break;
				case 6: line = board[0] + board[4] + board[8]; break;
				case 7: line = board[2] + board[4] + board[6]; break;
			}

			if(line.equals("XXX")) // Si gana el jugador X
				return "X";
			else if(line.equals("OOO")) // Si gana el jugador O
				return "O";
		}

		for(int a = 0; a < 9; a ++) {
            if(Arrays.asList(board).contains(String.valueOf(a + 1)))
                break;
            else if(a==8)
                return "DRAW";
		}

		System.out.println("\nEs el turneo de " + player + ", ingrese una casilla: ");

		return null;
	}

	//imprimir
	/*
	|-------|-------|-------|
	|	1	|	2	|	3	|
	|-------|-------|-------|
	|	4	|	5	|	6	|
	|-------|-------|-------|
	|	7	|	8	|	9	|
	*/

	public void printBoard() {
		System.out.println("\n|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		board = new String[9];
		player = "X";
		String winner = null;

		TicTacToe t = new TicTacToe();

		// Llenar la matriz board
		for(int i=0;i<9;i++)
			board[i] = String.valueOf(i+1);

		System.out.println("Bienvenido Tic Tac Toe 3x3");

		t.printBoard();

		System.out.println("Es el turneo de " + player + ", ingrese una casilla: ");
		while(winner == null) {
			int numSlot;

			numSlot = in.nextInt();
			if(!(numSlot>0 && numSlot<=9)) {
				System.out.println("Opcion no valida");
				continue;
			}

			if(board[numSlot-1].equals(String.valueOf(numSlot))) {
				board[numSlot-1] = player; // Player vale "X"
				if(player.equals("X"))
					player = "O";
				else
					player = "X";
				t.printBoard();
				winner = t.checkWinner();
			} else
				System.out.println("El slot ya esta ocupado");
		}

		if(winner.equals("DRAW"))
			System.out.println("Nadie gana. Gracias por jugar");
		else 
			System.out.println("Ganaste " + winner + " eres un PRO");

		in.close();
	}
}
