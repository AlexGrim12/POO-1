import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problema5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la fecha (DD/MM/YYYY): ");
        String fechaInput = scanner.nextLine();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fecha = LocalDate.parse(fechaInput, dateFormat);
        String diaDeLaSemana = fecha.getDayOfWeek().toString();
        
        if (diaDeLaSemana.equals("MONDAY")) {
            diaDeLaSemana = "Lunes";
        } else if (diaDeLaSemana.equals("TUESDAY")) {
            diaDeLaSemana = "Martes";
        } else if (diaDeLaSemana.equals("WEDNESDAY")) {
            diaDeLaSemana = "Miercoles";
        } else if (diaDeLaSemana.equals("THURSDAY")) {
            diaDeLaSemana = "Jueves";
        } else if (diaDeLaSemana.equals("FRIDAY")) {
            diaDeLaSemana = "Viernes";
        } else if (diaDeLaSemana.equals("SATURDAY")) {
            diaDeLaSemana = "Sabado";
        } else if (diaDeLaSemana.equals("SUNDAY")) {
            diaDeLaSemana = "Domingo";
        }
        
        System.out.println("El dia de la semana es: " + diaDeLaSemana);
        scanner.close();
    }
}