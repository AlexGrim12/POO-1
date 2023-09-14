public class ProgramaAdopcion {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Perro perro = new Perro();
        
        persona.setNombre("Luna");
        persona.setEdad(19);
        
        perro.setNombre("Licenciado");
        perro.setSexo("Macho");
        perro.setRaza("Malamute de Alaska");
        perro.setEdad(7);

        persona.setMascota(perro);

        System.out.println("Persona: \n" + persona.toString());
        System.out.println("\nMascota: \n" + perro.toString());

        perro.hacerSonido();
    }
}