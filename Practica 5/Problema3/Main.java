import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ahorcado game = new Ahorcado();
        String w = game.getSolution().toString();

        while(game.getLives() > 0 && !w.equals(game.getGuess().toString())) {
            System.out.println("Adivina: " + game.getGuess());
            game.paintAhorcado();

            System.out.print("\nLetra: ");
            char l = sc.next().charAt(0);
            l = Character.toUpperCase(l);
            game.checkLetter(l);
            System.out.println();
        }

        if(game.getLives() == 0)
            System.out.println("Perdiste :( La palabra era: " + w + "");
        else
            System.out.println("Adinivaste la palabra " + w + "!");

        sc.close();
    }
}