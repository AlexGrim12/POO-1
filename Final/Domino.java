import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Domino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Clip musica = null;

        // Reproduce la musica de fondo
        try {
            musica = AudioSystem.getClip();
            musica.open(AudioSystem.getAudioInputStream(new File("MoonlightSonata.wav")));
            musica.loop(Clip.LOOP_CONTINUOUSLY); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Pide el tipo de juego
        System.out.println("%%%%%%%%%%%%%%% Bienvenido a Domino %%%%%%%%%%%%%%%");
        System.out.println("Escoga el modo de juego:");
        System.out.println("1. Jugador vs Bot");
        System.out.println("2. Bot vs Bot");
        System.out.print("$ ");
        int tipoJuego = sc.nextInt();
        Mesa mesa = new Mesa(tipoJuego); // Crea la mesa con el tipo de juego escogido

        // Continua el bucle hasta que un jugador se quede sin fichas 
        // o se acaben las fichas en el pozo y ningun jugador pueda jugar
        while ((mesa.getJugadores().get(0).puedeJugar() || 
                mesa.getJugadores().get(1).puedeJugar()) || 
                !mesa.getPozo().isEmpty()) {
            // Limpia la consola
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Imprime las fichas en la mesa actual y el numero de fichas en el pozo
            System.out.println("\n\nMesa actual:");
            mesa.imprimir();
            System.out.println("\nNumero de fichas en el Pozo: " + mesa.getPozo().size());
            
            // Imprime las fichas del jugador con el turno actual
            System.out.println("\n%%%%% Turno de " + mesa.getJugadores().get(0).getNombre() + " %%%%%");
            mesa.imprimir(mesa.getJugadores().get(0).getFichas());

            if (mesa.getMesa().isEmpty()) // Solo para el primer turno
                mesa.getJugadores().get(0).primerTurno(mesa.getMesa());
            else {
                if (mesa.getJugadores().get(0).puedeJugar(mesa.getMesa())) // Si puede jugar, empieza su turno
                    mesa.getJugadores().get(0).turno(mesa.getMesa());
                else { // Si no puede jugar, roba una ficha
                    if (mesa.getPozo().isEmpty()) { // Si no hay fichas en el pozo, pasa su turno
                        System.out.println("No puedes jugar y no hay fichas en el pozo, pasas tu turno");

                        // Espera 3 segundos para que el jugador pueda leer el mensaje
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else { // Si hay fichas en el pozo, roba una ficha y pasa su turno
                        if (mesa.getJugadores().get(0) instanceof Humano)
                            System.out.println("Necesitas robar una ficha");
                        
                        // Espera 3 segundos para que el jugador pueda leer el mensaje
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Roba una ficha, imprime sus fichas y pasa su turno
                        System.out.println(mesa.getJugadores().get(0).getNombre() + " roba 1 ficha y pasa su turno");
                        mesa.getJugadores().get(0).robar(mesa.getPozo());
                        mesa.imprimir(mesa.getJugadores().get(0).getFichas());

                        // Espera 3 segundos para que el jugador pueda leer el mensaje
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            
            // Si el jugador se queda sin fichas gana
            if (mesa.getJugadores().get(0).getCantidadFichas() == 0) {
                System.out.println("\n\nMesa final:");
                mesa.imprimir(mesa.getMesa());
                break;
            }

            // Cambia el turno cambiando la posicion de los jugadores en el ArrayList
            mesa.cambioDeTurno();
        }
        
        // Detiene la musica de fondo y reproduce la musica de victoria
        try {
            if (musica != null)
                musica.stop();
            
            musica = AudioSystem.getClip();
            musica.open(AudioSystem.getAudioInputStream(new File("Victoria.wav")));
            musica.start();
        } catch (Exception e) {
            e.printStackTrace();
        }        

        if (!mesa.getJugadores().get(0).puedeJugar() && 
                !mesa.getJugadores().get(1).puedeJugar() &&
                mesa.getPozo().isEmpty() ) { // Si se acaban las fichas en el pozo y ningun jugador puede jugar
            int suma1 = 0, suma2 = 0;
            System.out.println("Se acabaron las fichas");

            // Calcula la suma de las fichas de cada jugador
            for (int i = 0; i < mesa.getJugadores().get(0).getCantidadFichas(); i++)
                suma1 += mesa.getJugadores().get(0).getFicha(i).getSuma();
            for (int i = 0; i < mesa.getJugadores().get(1).getCantidadFichas(); i++)
                suma2 += mesa.getJugadores().get(1).getFicha(i).getSuma();
            
            // Imprime el ganador de acuerdo a la suma de sus fichas
            if (suma1 < suma2)
                System.out.println("El ganador es " + mesa.getJugadores().get(0).getNombre());
            else if (suma1 > suma2)
                System.out.println("El ganador es " + mesa.getJugadores().get(1).getNombre());
            else
                System.out.println("Empate");
        } else // Si un jugador se queda sin fichas gana
           System.out.println("\n%%%%%%%%%%%%%%% El ganador es " + mesa.getJugadores().get(0).getNombre() + " %%%%%%%%%%%%%%%");
        
        // Espera 5 segundos para terminar el programa
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

        sc.close();
    }
}
