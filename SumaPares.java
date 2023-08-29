import java.util.Scanner;

public class SumaPares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = 0, n2 = 0, mayor, menor, suma = 0;

        System.out.print("Introduzca un numero entero: ");
        n1 = sc.nextInt();

        System.out.print("Introduzca otro numero entero: ");
        n2 = sc.nextInt();

        if (n1 > n2) {
            mayor = n1;
            menor = n2;
        } else {
            mayor = n2;
            menor = n1;
        }

        for(int i = menor; i <= mayor; i ++) {
            if (i % 2 == 0) 
                suma += i;
        }

        System.out.println("La suma de los pares entre " + n1 + " y " + n2 + " es: " + suma);

    }
}