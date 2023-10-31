public class Mexicano extends Persona {
    String curp; // Variable polimorfica
    
    Mexicano(String name, int edad, Sx sexo, String curp) {
        this.name = name;
        this.edad = edad;
        this.sexo = sexo;
        this.nacionalidad = "Mexicana";
        this.curp = curp;
    }

    @Override
    boolean votar() {
        return this.edad >= 18;
    }

    @Override
    boolean servicioMilitar() {
        return this.edad >= 17 && this.sexo == Sx.MASCULINO;
    }

    @Override
    boolean presidente() {
        return this.edad >= 35;
    }
}