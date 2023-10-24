import java.util.ArrayList;

public class Bot extends Jugador {
    public Bot(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void turno(ArrayList<Ficha> mesaActual) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    

        if (mesaActual.size() == 0) {
            int ficha = 0;
            int max = -1;
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getSuma() > max) {
                    max = fichas.get(i).getSuma();
                    ficha = i;
                }
            }
            mesaActual.add(fichas.get(ficha));
            System.out.println("Bot juega " + fichas.get(ficha));
            fichas.remove(ficha);
        } else {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getCaraIzq() == mesaActual.get(0).getCaraIzq()) {
                    fichas.get(i).girar();
                    mesaActual.add(0, fichas.get(i));
                    System.out.println(nombre + " juega " + fichas.get(i) + " a la izquierda");
                    fichas.remove(i);
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
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }
}
