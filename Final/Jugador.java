import java.util.ArrayList;

public abstract class Jugador {
    // Atributos
    protected String nombre;
    protected ArrayList<Ficha> fichas = new ArrayList<Ficha>();
    protected boolean puedeJugar = true;
    
    // M3todos getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public Ficha getFicha(int i) {
        return fichas.get(i);
    }
    
    public int getCantidadFichas() {
        return fichas.size();
    }

    // Agraga una ficha a las fichas del jugador
    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }

    // Devuelve true si el jugador tiene una ficha que puede jugar  (Sobrecarga de metodos)
    public boolean puedeJugar() {
        return puedeJugar;
    }

    // Devuelve true si el jugador tiene una ficha que puede jugar (Sobrecarga de metodos)
    public boolean puedeJugar(ArrayList<Ficha> mesaActual) {
        for (Ficha ficha : fichas) {
            // Revisa si algun lado de la ficha coincide con algun lado de las fichas en la mesa
            if (ficha.getCaraIzq() == mesaActual.get(0).getCaraIzq() || 
                    ficha.getCaraDer() == mesaActual.get(0).getCaraIzq() || 
                    ficha.getCaraIzq() == mesaActual.get(mesaActual.size() - 1).getCaraDer() || 
                    ficha.getCaraDer() == mesaActual.get(mesaActual.size() - 1).getCaraDer()) {
                puedeJugar = true;    
                return true;
            }
        }
        puedeJugar = false;
        return false;
    }

    // Roba una ficha del pozo y la agrega a las fichas del jugador
    public void robar(ArrayList<Ficha> pozo) {
        fichas.add(pozo.get(0));
        pozo.remove(0);
    }

    // Metodos abstractos que se implementan en las clases hijas
    public abstract void primerTurno(ArrayList<Ficha> mesaActual);
    public abstract void turno(ArrayList<Ficha> mesaActual);
}