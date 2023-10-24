import java.util.ArrayList;

public abstract class Jugador {
    protected String nombre;
    protected ArrayList<Ficha> fichas = new ArrayList<Ficha>();
    
    public String getNombre() {
        return nombre;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
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

    public boolean puedeJugar(ArrayList<Ficha> mesaActual) {
        for (Ficha ficha : fichas) {
            if (ficha.getCaraIzq() == mesaActual.get(0).getCaraIzq() || 
                ficha.getCaraDer() == mesaActual.get(0).getCaraIzq() || 
                ficha.getCaraIzq() == mesaActual.get(mesaActual.size() - 1).getCaraDer() || 
                ficha.getCaraDer() == mesaActual.get(mesaActual.size() - 1).getCaraDer())
                return true;
        }
        return false;
    }

    public void robar(ArrayList<Ficha> pozo) {
        fichas.add(pozo.get(0));
        pozo.remove(0);
    }

    public abstract void turno(ArrayList<Ficha> mesaActual);
}