import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mesa {
    private static ArrayList<Ficha> mesa = new ArrayList<Ficha>();
    private static ArrayList<Ficha> pozo = new ArrayList<Ficha>();
    private static List<Jugador> jugadores = new ArrayList<Jugador>() {{
        add(new Humano("Jugador 1"));
        add(new Bot("Bot 1"));
        add(new Bot("Bot 2"));
    }};
    
    public Mesa(int tipoJuego) {
        for (int i = 0; i <= 6; i++)
            for (int j = i; j <= 6; j++) 
                mesa.add(new Ficha(i, j));
        this.mezclar();
        if (tipoJuego == 1) 
            jugadores.remove(2);
        else if (tipoJuego == 2)
            jugadores.remove(0);
        this.repartir();
        this.primerTurno();
        mesa.clear();
    }
    
    public ArrayList<Ficha> getMesa() {
        return mesa;
    }

    public ArrayList<Ficha> getPozo() {
        return pozo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }


    public void mezclar() {
        Random random = new Random();
        for (int i = 0; i < mesa.size(); i++) {
            int j = random.nextInt(mesa.size());
            Ficha aux = mesa.get(i);
            mesa.set(i, mesa.get(j));
            mesa.set(j, aux);
        }
    }

    public void repartir() {
        for (int i = 0; i < 7; i++) {
            jugadores.get(0).agregarFicha(mesa.get(i));
            jugadores.get(1).agregarFicha(mesa.get(i + 7));
        }
        for (int i = 14; i < mesa.size(); i++) 
            pozo.add(mesa.get(i));
    }

    public void primerTurno() {
        int max = -1, mano = 0;
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
            moverAlFondo();
    }

    public void moverAlFondo() {
        Jugador aux = jugadores.get(1);
        jugadores.set(1, jugadores.get(0));
        jugadores.set(0, aux);
    }

    public void imprimir(ArrayList<Ficha> fichas) {
        for (int i = 1; i <= fichas.size(); i++)
            System.out.print("  " + i + "\t");
        System.out.println();
        for (Ficha ficha : fichas)
            System.out.print(ficha + "\t");
        System.out.println();
    }    
}
