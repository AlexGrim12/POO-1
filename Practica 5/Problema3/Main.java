import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ahorcado game = new Ahorcado();
        Palabra p = new Palabra();
        StringBuilder w = new StringBuilder(p.getWord());

        while(game.getLives() > 0 && !p.getHiddenWord().toString().equals(w.toString())) {
            System.out.println("Adivina: " + p.getHiddenWord());
            game.paintAhorcado();

            System.out.print("\nLetra: ");
            char l = sc.next().charAt(0);
            l = Character.toUpperCase(l);
            if(!p.guessLetter(l))
                game.loseLife();
            System.out.println();
        }

        if(game.getLives() == 0)
            System.out.println("Perdiste :( La palabra era: " + w + "");
        else
            System.out.println("Adivinaste la palabra " + w + "!");

        sc.close();
    }
}
