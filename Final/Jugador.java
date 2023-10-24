import java.util.ArrayList;

public abstract class Jugador {
    protected String nombre;
    protected ArrayList<Ficha> fichas = new ArrayList<Ficha>();
    protected boolean puedeJugar = true;
    
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public Ficha getFicha(int i) {
        return fichas.get(i);
    }

    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }

    public int getCantidadFichas() {
        return fichas.size();
    }

    public boolean puedeJugar() {
        return puedeJugar;
    }

    public boolean puedeJugar(ArrayList<Ficha> mesaActual) {
        for (Ficha ficha : fichas) {
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

    public void robar(ArrayList<Ficha> pozo) {
        fichas.add(pozo.get(0));
        pozo.remove(0);
    }

    public abstract void primerTurno(ArrayList<Ficha> mesaActual);
    public abstract void turno(ArrayList<Ficha> mesaActual);
}