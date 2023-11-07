abstract class Persona {
    String nombre;
    int edad;
    Sx sexo;
    String nacionalidad;

    public String getNombre() {
        return this.nombre;
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