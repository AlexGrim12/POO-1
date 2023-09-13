import java.util.Random;

public class Referencia {
    public static void main(String[] args) {
        int a; // Variable de referencia
        a = 10;

        Random y; 
        y = new Random();
        Random x = y;

        for(int i = 0; i <= 10; i ++) {
            if (i == 2 || i == 3) {
                continue;
            }
            System.out.println(i);
            
        }
    }
}