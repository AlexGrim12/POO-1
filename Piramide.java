import java.util.Random;

public class Piramide {
    public static void main(String[] args) {
        Random rand = new Random();

        int b = rand.nextInt(10)+1;
        int espacio = b;
        
        // El primer for controla los niveles
        for(int i = 1; i <= b; i ++) {
            // El segundo for controla la cantidad de espacios para alinear los asteriscos
            for(int j = 0; j < espacio; j ++)
                System.out.print(" ");            
            espacio --;

            // El tercer for controla la cantidad de asteriscos por nivel
            for(int k = 0; k < i; k ++ )
                System.out.print("* ");
            System.out.println(" ");
        }
    }
}