import java.util.Scanner;

public class FigurasGeometricas2 {
    static float area = 20;
    
    public static void main(String[] args) {
        float area = 0;
        int opcion;
        final float PI = 3.1415f;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Elige una opcion");
            System.out.println("1. Area de un circulo");
            System.out.println("2. Area de un triangulo");
            System.out.println("3. Area de un cuadrado");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Circulo
                    float radio = 0;
                    System.out.print("Ingrese el valor del radio: ");
                    radio = sc.nextFloat();
                    area = PI * radio * radio;
                    break;
                case 2:
                    // Triangulo
                    float base = 0, altura = 0;
                    System.out.print("Ingrese el valor de la base: ");
                    base = sc.nextFloat();
                    System.out.print("Ingrese el valor de la altura: ");
                    altura = sc.nextFloat();
                    area = (base * altura) / 2;
                    break;
                case 3: 
                    // Cuadrado
                    float lado = 0;
                    System.out.print("Ingrese el valor del lado: ");
                    lado = sc.nextFloat();
                    area = lado * lado;
                    break;
                case 4:
                    System.out.println("Bye");
                    continue;
                default: 
                    System.out.println("Su eleccion no existe");
                    continue;
            }

            System.out.println("El area es: " + area + "\n");

        } while(opcion != 4);
        
        sc.close();
    }
} 