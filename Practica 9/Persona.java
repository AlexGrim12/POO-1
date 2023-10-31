abstract class Persona {
    String name;
    int edad;
    Sx sexo;
    String nacionalidad;

    public String getNombre() {
        return this.name;
    }

    public int getEdad() {
        return this.edad;
    }

    public Sx getSexo() {
        return this.sexo;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    abstract boolean votar();
    abstract boolean servicioMilitar();
    abstract boolean presidente();
}