import java.util.Scanner;

public class Problema1 {
    static StringBuilder cipher(String m, int n) {
        int mLen = m.length();
        int cols;
        StringBuilder sb = new StringBuilder(m);

        if (mLen % n != 0) {
            cols = (mLen / n) + 1;
            for(int i = 0; i < (n * cols) - mLen; i ++)
                sb.append(' ');
        } else 
            cols = mLen / n;
        
        char[][] matrix = new char[n][cols];
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++)
                matrix[i][j] = sb.charAt((i * cols) + j);
        }
        
        StringBuilder cipher = new StringBuilder();
        for(int i = 0; i < matrix[0].length; i ++) {
            for(int j = 0; j < matrix.length; j ++)
                cipher.append(matrix[j][i]);
        }

        return cipher;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mensaje;
        int n;

        System.out.print("Mensaje: ");
        mensaje = sc.nextLine();
        do {
            System.out.print("n: ");
            n = sc.nextInt();
            if (n <= 0)
                System.out.println("n debe ser positivo\n");
        } while(n <= 0);

        System.out.println("\n" + cipher(mensaje, n));

        sc.close();
    }
}
