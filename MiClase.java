import java.util.Random;

public class MiClase {
    public static void main(String[] args) {
        // System.out.println("Esta es mi clase Hola Mundo");

        Random rand = new Random();

        // Obtenos un nùmero aleatorio entre 1-10
        int b = rand.nextInt(10)+1;

        for(int i = 1; i <= b; i ++) {
            for(int j = 0; j < i; j ++)
                System.out.print("* ");
            System.out.println(" ");
        }
    }
}