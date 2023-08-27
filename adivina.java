// 32020610-2. Acosta Porcayo Alan Omar.

import java.util.Scanner;
import java.util.Random;

public class Adivina {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random t = new Random();

        int i = 4, a = t.nextInt(100);

        while (i > 0) {
            System.out.print("Adivina el numero entre 0-99 : ");
            int b = s.nextInt();
            i--;

            if (a == b)
                break;
            else if (i != 0){
                System.out.println("Un intento menos");
                System.out.println(a > b ? "Mas\n" : "Menos\n");
            }
        }
        s.close();

        System.out.println(i == 0 ? "\nNo pudiste! El numero aleatorio es: " + a : "\nLe atinaste al numero aleatorio");
    }
}