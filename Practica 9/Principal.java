import java.util.HashMap;

public class Principal {
    public static void main(String[] args) throws Outer_MyException {
        HashMap<String, Persona> gente = new HashMap<String, Persona>();
        gente.put("AOPS096509HFJKL7", new Mexicano("Erick ", 19, Sx.MASCULINO, "AOPS096509HFJKL7"));
        gente.put("ATPS086509HFJKL8", new Mexicano("Amir  ", 19, Sx.INDEFINIDO, "ATPS086509HFJKL8"));
        gente.put("AOPS096509HFJKL9", new Mexicano("Abner ", 10, Sx.MASCULINO, "AOPS096509HFJKL9"));
        gente.put("AOPS096509HFJKL0", new Mexicano("Sofia ", 19, Sx.FEMENINO, "AOPS096509HFJKL0"));
        gente.put("AOPS096509HFJKL1", new Mexicano("Irandi", 19, Sx.FEMENINO, "AOPS096509HFJKL1"));
        
        gente.forEach((k, p) -> {System.out.println(k + " : Nombre: " + p.getNombre() + "| Edad: " + p.getEdad());});

        gente.forEach((k, p) -> {
            try {
                if(!p.votar()) throw new Outer_MyException();
            } catch (Outer_MyException e) {
               System.out.println(e.getMessage());
            }
        });
    }
}  