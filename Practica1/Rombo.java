import java.util.Scanner;

public class Rombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k;

        do {
            System.out.print("Ingrese un numero mayor que 1: ");
            k = scanner.nextInt();
            
            if (k <= 1) 
                System.out.println("Valor Invalido\n");
        } while(k <= 1);
        scanner.close();
        
        for (int i = 1; i <= k; i++) {
            for (int j = k - i; j > 0; j--) {
                System.out.print(" ");
            }
            
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            
            System.out.println();
        }
        
        for (int i = k - 1; i >= 1; i--) {
            for (int j = k - i; j > 0; j--) {
                System.out.print(" ");
            }
            
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            
            System.out.println();
        }
    }
}
