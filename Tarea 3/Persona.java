class Persona {
    private String nombre;
    private int edad;
    private Mascota mascota;

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

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String toString() {
        if(mascota != null)
            return "Nombre: " + this.getNombre() + "\nEdad: " + this.getEdad() + "\nMascota: " + mascota.getNombre();
        else
            return "Nombre: " + this.getNombre() + "\nEdad: " + this.getEdad() + "\nMascota: No tiene";
    }
}