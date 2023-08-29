import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Ingrese el valor de n: ");
        n = sc.nextInt();

        for(int i = 2; i <= n; i ++) {
            System.out.print(((i % 2 == 0 & i != 2) || (i % 3 == 0 & i != 3) || (i % 5 == 0 & i != 5) || (i % 7 == 0 & i != 7)) ? "" : i + " ");
        }
        System.out.println();
        sc.close();
    }
}