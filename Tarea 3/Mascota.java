class Mascota {
    private String nombre;
    private int edad;
    private String sexo;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void hacerSonido() {
        System.out.println("La mascota hace un sonido.");
    }

    public String toString() {
        return "Nombre: " + this.getNombre() + "\nEdad: " + this.getEdad() + "\nSexo: " + this.getSexo();
    }
}
