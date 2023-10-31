public class Extranjero extends Persona {
    Extranjero(String name, int edad, Sx sexo, String nacionalidad) {
        this.name = name;
        this.edad = edad;
        this.sexo = sexo;
        this.nacionalidad = "Extranjera";
    }        

    @Override
    boolean votar() {
        return false;
    }

    @Override
    boolean servicioMilitar() {
        return false;
    }

    @Override
    boolean presidente() {
        return false;
    }
}