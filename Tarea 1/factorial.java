// 32020610-2. Acosta Porcayo Alan Omar.

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Ingrese el valor de n para calcular su factorial: ");
        int n = sc.nextInt(), factorial = 1;
        sc.close();

        for(int aux = n; aux > 1; aux --) {
            factorial *= aux;
        }

        System.out.println("El factorial de " + n + " es: " + factorial);
    }
}
