package problema2;

public class Fabrica {
    public static void main(String[] args) {
        Vehiculo a = new Avion(); //Upcasting
        
        if (a instanceof Avion) {
            System.out.println("a es una instancia de Avion");
        }
        if (a instanceof Vehiculo) {
            System.out.println("a es una instancia de Vehiculo");
        }
        //Avion b = new Vehiculo();

        Vehiculo b = (Vehiculo) a;
        if (b instanceof Avion) {
            System.out.println("b es una instancia de Avion");
        }
        if (b instanceof Vehiculo) {
            System.out.println("b es una instancia de Vehiculo");
        }

        Barco titanic = new Barco();
        titanic.setNumSerie("KLA0009101");
        System.out.println(titanic);

        Automovil mercedes = new Automovil();
        mercedes.setNumSerie("MNX0009101");
        System.out.println(mercedes);

        Avion boeing = new Avion();
        boeing.setNumSerie("BOE0009101");
        System.out.println(boeing);
    }
}