// Realice un programa en JAVA que calcule la suma de los primeros n números naturales, donde n sea un parámetro que se recibe del teclado. 

import java.util.Scanner;

public class suma_n_naturales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de n: ");
        int n = sc.nextInt(), suma = 0;
        sc.close();

        for(int i = 1; i <= n; i ++) {
            suma += i;
        }

        System.out.println("El valor de la suma de los primeros " + n + " naturales es: " + suma);

    }
}
