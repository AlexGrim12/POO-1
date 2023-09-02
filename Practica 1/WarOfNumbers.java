import java.util.Random;

public class WarOfNumbers {
    public static void main(String[] args) {
        Random rand = new Random();

        int number, evenSum = 0, oddSum = 0, diff;

        System.out.print("Numeros: ");
        for(int i = 0; i < 10; i ++) {
            number = rand.nextInt(1000) + 1;
            System.out.print(number + " ");
            
            if (number % 2 == 0) 
                evenSum += number;
            else 
                oddSum += number;
        }

        System.out.println("\nSuma de pares: " + evenSum);
        System.out.println("Suma de impares: " + oddSum);

        if(evenSum >= oddSum)
            diff = evenSum - oddSum;
        else 
            diff = oddSum - evenSum;

        System.out.println("Diferencia: " + diff);
    }
}
