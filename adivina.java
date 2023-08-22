import java.util.Scanner;
import java.util.Random;

public class adivina{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        
        int tries = 4, ranNum = ran.nextInt(100) + 1, guess;
        
        while(tries > 0) {
            System.out.print("Adivina el numero entre 1-100: ");
            guess = sc.nextInt();
            tries --;

            if (guess == ranNum && tries > 0) {
                System.out.println("ERES UN PRO! le atinaste al numero aleatorio");
                break;
            } else if (tries > 0) {
                System.out.print("Un intento menos\t");
                if(guess > ranNum) System.out.println("Menos\n");
                else System.out.println("Mas\n");
            }
        }

        if (tries == 0) System.out.println("\nNo pudiste!");
        System.out.println("El numero aleatorio es: " + ranNum);
        sc.close();
    }
}