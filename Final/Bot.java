import java.util.ArrayList;

public class Bot extends Jugador {
    // Metodo constructor
    public Bot(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void primerTurno(ArrayList<Ficha> mesaActual) {
        int ficha = -1;
        int max = -1;

        // Busca la mula con el numero mas alto
        for (Ficha f : fichas) {
            if (f.esMula() && f.getSuma() > max) {
                max = f.getSuma();
                ficha = fichas.indexOf(f);
            }
        }

        if (ficha != -1) // Si tiene mula, la juega
            System.out.println(nombre + " juega la mula mas alta: " + fichas.get(ficha));
        else { // Si no tiene mula, juega la ficha con el numero mas alto
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getSuma() > max) {
                    max = fichas.get(i).getSuma();
                    ficha = i;
                }
            }
            System.out.println(nombre + " juega la ficha mas alta: " + fichas.get(ficha));
        }

        // Agrega la ficha a la mesa y la quita de las fichas del jugador
        mesaActual.add(fichas.get(ficha));
        fichas.remove(ficha);
        
        // Espera 3 segundos para que el jugador pueda leer el mensaje
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void turno(ArrayList<Ficha> mesaActual) {
        // Espera 3 segundos para que el jugador pueda leer el mensaje
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    

        // Busca la primera ficha que pueda jugar y la juega
        for (int i = 0; i < fichas.size(); i++) {
            if (fichas.get(i).getCaraIzq() == mesaActual.get(0).getCaraIzq()) {
                fichas.get(i).girar(); // Gira la ficha si es necesario
                mesaActual.add(0, fichas.get(i)); // Agrega la ficha a la mesa
                System.out.println(nombre + " juega " + fichas.get(i) + " a la izquierda");
                fichas.remove(i); // Quita la ficha de las fichas del jugador
                break;
            } else if (fichas.get(i).getCaraDer() == mesaActual.get(0).getCaraIzq()) {
                mesaActual.add(0, fichas.get(i));
                System.out.println(nombre + " juega " + fichas.get(i) + " a la izquierda");
                fichas.remove(i);
                break;
            } else if (fichas.get(i).getCaraIzq() == mesaActual.get(mesaActual.size() - 1).getCaraDer()) {
                mesaActual.add(fichas.get(i));
                System.out.println(nombre + " juega " + fichas.get(i) + " a la derecha");
                fichas.remove(i);
                break;
            } else if (fichas.get(i).getCaraDer() == mesaActual.get(mesaActual.size() - 1).getCaraDer()) {
                fichas.get(i).girar();
                mesaActual.add(fichas.get(i));
                System.out.println(nombre + " juega " + fichas.get(i) + " a la derecha");
                fichas.remove(i);
                break;
            }
        }

        // Espera 3 segundos para que el jugador pueda leer el mensaje
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }
}
