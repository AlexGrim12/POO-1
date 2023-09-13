import java.util.Scanner;

public class Palindromo {
    public static Boolean esPalindromo(String palabra) {
        StringBuilder palabraInvertida = new StringBuilder(palabra);
        palabraInvertida.reverse();
        return palabra.equals(palabraInvertida.toString());
    } 
    
    public static void main(String[] args) {
        String palabra;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una palabra: ");
        palabra = sc.nextLine();
        
        System.out.println(esPalindromo(palabra));
        sc.close();
    }
}
