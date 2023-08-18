/*
 * Realice un programa en JAVA que calcule el factorial de un numero natural n incluyendo 
 * el cero usando un ciclo for decremental, n puede ser una variable fija dentro del programa.
 */

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
