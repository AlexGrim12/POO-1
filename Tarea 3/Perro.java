class Perro extends Mascota {
    private String raza;

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println("\nEl perro ladra.");
    }

    public String toString() {
        return super.toString() + "\nRaza: " + this.getRaza();
    }
}