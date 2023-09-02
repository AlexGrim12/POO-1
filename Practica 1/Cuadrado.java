import java.util.Random;

public class Cuadrado {
    public static void main(String[] args) {
        Random rand = new Random();

        int m = rand.nextInt(20) + 1;
        boolean flag;

        if(m % 2 == 0) 
            flag = false;
        else
            flag = true;

        for(int i = 0; i < m; i ++) {
            if (i == 0 || i == m - 1) {
                for(int j = 0; j < m; j ++)
                    System.out.print("+ ");
                System.out.println("");
            } else {
                System.out.print("+");

                for(int j = 0; j < (m - 2)*2 + 1; j ++) {
                    if (i == m / 2 && flag == true && j == m - 2)
                        System.out.print("+");
                    else
                        System.out.print(" ");
                }

                System.out.println("+");
            }
        }
    }
}
