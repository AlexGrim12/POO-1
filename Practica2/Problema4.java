import java.util.Scanner;

public class Problema4 {
    static int mubashirFunction(int x, int y) {
        String xS = Integer.toString(x), yS = Integer.toString(y);
        int xL = xS.length(), yL = yS.length(), xSum = 0, ySum = 0;

        for(int i = 0; i < xL; i++)
           xSum += Character.getNumericValue(xS.charAt(i));
        
        for(int i = 0; i < yL; i++)
            ySum += Character.getNumericValue(yS.charAt(i));
        
        return xSum * ySum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x = ");
        int x = sc.nextInt();
        System.out.print("y = ");
        int y = sc.nextInt();

        System.out.println("\n" + mubashirFunction(x, y));

        sc.close();
    }
}
