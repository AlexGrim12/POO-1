import java.util.Random;
import java.util.Scanner;

public class TextTwist {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int r = rand.nextInt(5);  
        int tries = 10;  
        int score = 0;
        
        Word w;
        switch(r) {
            case 0: w = new Word("SELECT", "CEL","SET", "ELSE", "ELECT", "STEEL"); break;
            case 1: w = new Word("DATING", "AND", "ANTI", "DING", "GAIN", "GIANT"); break;
            case 2: w = new Word("VALUES", "SEA", "USE", "SAVE", "SALE", "SLAVES"); break;
            case 3: w = new Word("MANGOS", "MAN",  "GAS", "SON", "SONG", "AMONG"); break;
            default: w = new Word("UNMADE", "END", "AMEN", "MEAN", "MENU", "NAMED"); break;
        }

        System.out.println("*** Bienvenido a TextTwist ***");
        System.out.println("Tienes 10 intentos para adivinar las 5 palabras (en ingles)");
        System.out.println("La palabra revuelta es: " + w.scrambled);
        
        while(tries > 0 && w.solutions.size() > 0) {
            System.out.println("\nTe quedan " + tries + " intentos");

            System.out.print("Ingresa tu respuesta: ");
            String s = sc.nextLine();

            int p = w.points(s);
            score += p;

            System.out.println("Ganaste " + p + " puntos\n");
            tries--;
        }

        if(tries == 0)
            System.out.println("Se te acabaron los intentos");
        else 
            System.out.println("Felicidades, adivinaste todas las palabras");

        System.out.println("\nTu puntaje final es: " + score);
        sc.close();
    }
}
