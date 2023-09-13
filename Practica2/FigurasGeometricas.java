import java.util.Scanner;

public class FigurasGeometricas {
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
                    float radio = 15;
                    area = PI * radio * radio;
                    break;
                case 2:
                    // Triangulo
                    float base = 8, altura = 5;
                    area = (base * altura) / 2;
                    break;
                case 3: 
                    // Cuadrado
                    float lado = 10;
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