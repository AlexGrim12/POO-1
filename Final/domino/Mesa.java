package domino;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mesa {
    // Atributos
    private static ArrayList<Ficha> mesa = new ArrayList<Ficha>();
    private static ArrayList<Ficha> pozo = new ArrayList<Ficha>();
    private static List<Jugador> jugadores = new ArrayList<Jugador>() {{
        add(new Humano("Jugador 1"));
        add(new Bot("Bot 1"));
        add(new Bot("Bot 2"));
    }};
    
    // Metodo constructor
    public Mesa(int tipoJuego) {
        // Crea las 28 fichas y las agrega a la mesa
        for (int i = 0; i <= 6; i++) 
            for (int j = i; j <= 6; j++) 
                mesa.add(new Ficha(i, j));
        this.mezclar(); // Mezcla las fichas

        // Elimina un jugador dependiendo del tipo de juego
        if (tipoJuego == 1)  
            jugadores.remove(2);
        else if (tipoJuego == 2)
            jugadores.remove(0);

        this.repartir(); // Reparte las fichas
        this.decidirPrimerTurno(); // Decide quien empieza
        mesa.clear(); 
    }

    // Metodos getters
    public ArrayList<Ficha> getMesa() {
        return mesa;
    }

    public ArrayList<Ficha> getPozo() {
        return pozo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    // Mezcla las fichas aleatoriamente
    private void mezclar() {
        Random random = new Random();
        for (int i = 0; i < mesa.size(); i++) {
            int j = random.nextInt(mesa.size());
            Ficha aux = mesa.get(i);
            mesa.set(i, mesa.get(j));
            mesa.set(j, aux);
        }
    }

    // Reparte 7 fichas a cada jugador y agrega las demas al pozo
    private void repartir() {
        for (int i = 0; i < 7; i++) {
            jugadores.get(0).agregarFicha(mesa.get(i));
            jugadores.get(1).agregarFicha(mesa.get(i + 7));
        }
        for (int i = 14; i < mesa.size(); i++) 
            pozo.add(mesa.get(i));
    }

    // Decide quien empieza 
    private void decidirPrimerTurno() {
        int max = -1, mano = -1;

        // Busca la mula con el numero mas alto
        for (int i = 0; i < 7; i ++) { 
            if (jugadores.get(0).getFicha(i).esMula() && jugadores.get(0).getFicha(i).getSuma() > max) {
                max = jugadores.get(0).getFicha(i).getSuma();
                mano = 0;
            }
            if (jugadores.get(1).getFicha(i).esMula() && jugadores.get(1).getFicha(i).getSuma() > max) {
                max = jugadores.get(1).getFicha(i).getSuma();
                mano = 1;
            }
        }

        // Si hay mula, el jugador que tenga la mula mas alta empieza
        if (mano != -1) {
            if (mano == 1)
                cambioDeTurno(); // Si el jugador 1 tiene la mula mas alta, cambia su posicion en el ArrayList
            return;
        }
        
        // Si no hay mula, busca la ficha con el numero mas alto
        max = -1;
        for (int i = 0; i < 7; i ++) {
            if (jugadores.get(0).getFicha(i).getSuma() > max) {
                max = jugadores.get(0).getFicha(i).getSuma();
                mano = 0;
            }
            if (jugadores.get(1).getFicha(i).getSuma() > max) {
                max = jugadores.get(1).getFicha(i).getSuma();
                mano = 1;
            }
        }

        if (mano == 1)
            cambioDeTurno(); // Si el jugador 1 tiene la ficha mas alta, cambia su posicion en el ArrayList
    }

    // Cambia el turno de los jugadores moviendo los elementos en el ArrayList
    public void cambioDeTurno() {
        Jugador aux = jugadores.get(1);
        jugadores.set(1, jugadores.get(0));
        jugadores.set(0, aux);
    }

    // Imprime las fichas de la mesa (Sobrecarga de metodos)
    public void imprimir() {
        for (Ficha ficha : mesa)
            System.out.print(ficha + "\t");
        System.out.println();
    }

    // Imprime las fichas de un jugador (Sobrecarga de metodos)
    public void imprimir(ArrayList<Ficha> fichas) {
        // Imprime los numeros de las fichas
        for (int i = 1; i <= fichas.size(); i++)
            System.out.print("  " + i + "\t");
        System.out.println();

        for (Ficha ficha : fichas)
            System.out.print(ficha + "\t");
        System.out.println();
    }    
}
