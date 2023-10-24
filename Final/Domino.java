import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Domino {
    public static void decidirGanador(Mesa mesa) {
        int suma1 = 0, suma2 = 0;
        System.out.println("Se acabaron las fichas");
        for (int i = 0; i < mesa.getJugadores().get(0).getCantidadFichas(); i++)
            suma1 += mesa.getJugadores().get(0).getFicha(i).getSuma();
        for (int i = 0; i < mesa.getJugadores().get(1).getCantidadFichas(); i++)
            suma2 += mesa.getJugadores().get(1).getFicha(i).getSuma();
        if (suma1 < suma2)
            System.out.println("El ganador es " + mesa.getJugadores().get(0).getNombre());
        else if (suma1 > suma2)
            System.out.println("El ganador es " + mesa.getJugadores().get(1).getNombre());
        else
            System.out.println("Empate");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File("MoonlightSonata.wav")));
            sonido.loop(Clip.LOOP_CONTINUOUSLY); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("%%%%%%%%%%%%%%% Bienvenido a Domino %%%%%%%%%%%%%%%");
        System.out.println("Escoga el modo de juego:");
        System.out.println("1. Jugador vs Bot");
        System.out.println("2. Bot vs Bot");
        System.out.print("$ ");
        int tipoJuego = sc.nextInt(), flag = 0;
        Mesa mesa = new Mesa(tipoJuego);


        while (flag != 2) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("\n\nMesa actual:");
            mesa.imprimir(mesa.getMesa());
            System.out.println("\nFichas en el Pozo: " + mesa.getPozo().size());
            
            System.out.println("\n%%%%% Turno de " + mesa.getJugadores().get(0).getNombre() + " %%%%%");
            mesa.imprimir(mesa.getJugadores().get(0).getFichas());

            if (mesa.getMesa().size() == 0)
                mesa.getJugadores().get(0).turno(mesa.getMesa());
            else {
                int fichasRobadas = 1;
                while (mesa.getPozo().size() != 0 && !mesa.getJugadores().get(0).puedeJugar(mesa.getMesa())) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(mesa.getJugadores().get(0).getNombre() + " roba " + fichasRobadas++ + " ficha(s)");
                    mesa.getJugadores().get(0).robar(mesa.getPozo());
                    mesa.imprimir(mesa.getJugadores().get(0).getFichas());
                }
                
                if (mesa.getPozo().size() == 0) {
                    System.out.println(mesa.getJugadores().get(0).getNombre() + " pasa su turno");
                    flag ++;
                } else 
                    mesa.getJugadores().get(0).turno(mesa.getMesa());
            }
                
            if (mesa.getJugadores().get(0).getCantidadFichas() == 0) {
                System.out.println("\n\nMesa final:");
                mesa.imprimir(mesa.getMesa());
                flag = 0;
                break;
            }

            mesa.moverAlFondo();
        }

        if (flag == 2) 
            decidirGanador(mesa);
        else
           System.out.println("\n%%%%%%%%%%%%%%% El ganador es " + mesa.getJugadores().get(0).getNombre() + " %%%%%%%%%%%%%%%");
        
        sc.close();
    }
}
