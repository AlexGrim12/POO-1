import java.util.Scanner;

public class Problema1 {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la tienda en linea");
        System.out.println("En la tienda tenemos los siguiente productos: ");
        System.out.println("1. Audifonos $500");
        System.out.println("2. Cargador $300");
        System.out.println("3. Funda $200");
        System.out.println("4. Protector de pantalla $100");
        System.out.println("5. Cable USB $150");
        System.out.println("6. Memoria USB $250");
        System.out.println("7. Bocina $600");
        System.out.println("8. Mouse $350");
        System.out.println("9. Teclado $400");
        System.out.println("10. Smartwatch $1,000");
        System.out.println("11. Reloj $800");
        System.out.println("12. Lampara $1,200");
        System.out.println("13. Camara $1,500");
        System.out.println("14. Celular $2,000");
        System.out.println("15. Laptop $10,000");
        System.out.println("16. Monitor $5,000");
        System.out.println("17. Impresora $3,000");
        System.out.println("18. SSD 1T $1,500");
        System.out.println("19. SSD 2T $2,500");
        System.out.println("20. SSD 4T $4,500");

        Scanner scanner = new Scanner(System.in);

        int cantidadProductos = 0;
        int producto = 0;
        int total = 0;
        int descuento = 0;

        System.out.println("Cuantos productos desea comprar? (Entre 1 y 20)");
        while (cantidadProductos < 1 || cantidadProductos > 20) {
            cantidadProductos = scanner.nextInt();
            if (cantidadProductos < 1 || cantidadProductos > 20) {
                System.out.println("El numero debe estar entre 1 y 20, ingrese nuevamente:");
            }
        }

        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("Ingrese el numero del producto " + (i + 1) + ":");
            producto = scanner.nextInt();
            switch (producto) {
                case 1: total += 500; break;
                case 2: total += 300; break;
                case 3: total += 200; break;
                case 4: total += 100; break;
                case 5: total += 150; break;
                case 6: total += 250; break;
                case 7: total += 600; break;
                case 8: total += 350; break;
                case 9: total += 400; break;
                case 10: total += 1000; break;
                case 11: total += 800; break;
                case 12: total += 1200; break;
                case 13: total += 1500; break;
                case 14: total += 2000; break;
                case 15: total += 10000; break;
                case 16: total += 5000; break;
                case 17: total += 3000; break;
                case 18: total += 1500; break;
                case 19: total += 2500; break;
                case 20: total += 4500; break;
                default:
                    System.out.println("El producto no existe, ingrese nuevamente:");
                    i--;
                    break;
            }
        }
        scanner.close();

        if (total > 2000 && total < 4000) {
            descuento = (int) (total * 0.05);
        } else if (total >= 4000) {
            descuento = (int) (total * 0.07);
        }

        System.out.println("El total de su compra es: $" + total);
        System.out.println("El descuento es: $" + descuento);
        System.out.println("El total a pagar es: $" + (total - descuento));
    }
}
