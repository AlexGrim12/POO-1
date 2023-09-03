import java.util.Scanner;

public class Problema3 {
    static String Generation(int n, char s) {
        switch(n) {
            case -3:
                return (s == 'm') ? "great grandfather" : "great grandmother";
            case -2:
                return (s == 'm') ? "grandfather" : "grandmother";
            case -1:
                return (s == 'm') ? "father" : "mother";
            case 0:
                return "me!";
            case 1:
                return (s == 'm') ? "son" : "daughter";
            case 2:
                return (s == 'm') ? "grandson" : "granddaughter";
            case 3:
                return (s == 'm') ? "great grandson" : "great granddaughter";
            default:
                return "";
        }
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        char s;
        
        do {
            System.out.print("Ingrese el numero de generacion (entre -3 y 3): ");
            n = sc.nextInt();

            if(n < -3 || n > 3)
                System.out.println("Error. Valor fuera de rango\n");
        } while (n < -3 || n > 3);

        do {
            System.out.print("Ingrese el sexo (m/f): ");
            s = sc.next().charAt(0);

            if(s != 'm' && s != 'f')
                System.out.println("Error. Valor invalido\n");
        } while (s != 'm' && s != 'f');

        System.out.println("\n" + Generation(n, s));
        sc.close();
    }

}
