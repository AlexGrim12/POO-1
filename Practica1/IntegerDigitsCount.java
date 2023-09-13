import java.util.Random;

public class IntegerDigitsCount {
    public static void main(String[] args) {
        Random random = new Random();

        int randomNumber = random.nextInt(10000) + 1;
        int digitCount = 0;
        int number = randomNumber;
        
        if (number == 0) {
            digitCount = 1;
        } else {
            while (number != 0) {
                digitCount++;
                number /= 10;
            }
        }

        System.out.println("Numero generado: " + randomNumber);
        System.out.println("Cantidad de digitos: " + digitCount);  
    }  
}
