package src;
import src.battle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Battle {
    static ArrayList<Transformer> b1 = new ArrayList<Transformer>();
    static ArrayList<Transformer> b2 = new ArrayList<Transformer>();
    
    public static void assignLeaders() {
        ArrayList<Weapons> w1 = new ArrayList<Weapons>();
        w1.add(new AtkWeapons("Espada de los prime", 16));
        w1.add(new AtkWeapons("Hacha de Energon", 20));
        Transformer leader1 = (Transformer) new Autobot("Optimus Prime", 120, 120, w1);

        ArrayList<Weapons> w2 = new ArrayList<Weapons>();
        w2.add(new AtkWeapons("Taladro cybertroiano", 12));
        Transformer leader2 = (Transformer) new Predacon("Razorclaw", 100, 100, w2);

        b1.add(leader1);
        b2.add(leader2);
    }

    public static void makeTeams() {
        Random rand = new Random();
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Adrian", "Bruno", "Carlos", "David", "Eduardo", "Fernando", "Gabriel", "Juan"));
        ArrayList<Weapons> atkWeapons = new ArrayList<Weapons>();
        ArrayList<Weapons> defWeapons = new ArrayList<Weapons>();
        
        atkWeapons.add(new AtkWeapons("Cañón de ion", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Cañón láser", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Golpe de energía", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Rayo de calor", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Cañón de plasma", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Cañón de rayos", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Golpe de fuerza", rand.nextInt(6) + 15));
        atkWeapons.add(new AtkWeapons("Rayo de congelación", rand.nextInt(6) + 15));
        
        defWeapons.add(new DefWeapons("Escudo de energía", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Campo de fuerza", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Bombas de humo", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Blindaje sónico", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Blindaje electromagnético", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Granada de Anulación", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Disruptor de Campos", rand.nextInt(6) + 15));
        defWeapons.add(new DefWeapons("Escudo de examenes ;)", rand.nextInt(6) + 15));
        
        for (int i = 0; i < 8; i++) {
            ArrayList<Weapons> w = new ArrayList<Weapons>();
            int iName = rand.nextInt(names.size());
            int nWeapons = rand.nextInt(atkWeapons.size());
            int endurance = rand.nextInt(51) + 70;

            String name = names.get(iName);
            names.remove(iName);

            w.add(atkWeapons.get(nWeapons));
            atkWeapons.remove(nWeapons);
            w.add(defWeapons.get(nWeapons));
            defWeapons.remove(nWeapons);
            
            int race = rand.nextInt(4);
            int team = rand.nextInt(2);
            
            if (team == 0 && b1.size() <= 4 || b2.size() > 4) {
                switch (race) {
                    case 0: 
                        Autobot mA = new Autobot(name, endurance, endurance, w); 
                        b1.add(mA);
                        break;
                    case 1: 
                        Decepticon mD = new Decepticon(name, endurance, endurance, w); 
                        b1.add(mD);
                        break;
                    case 2:
                        Maximal mM = new Maximal(name, endurance, endurance, w); 
                        b1.add(mM);
                        break;
                    default:
                        Predacon mP = new Predacon(name, endurance, endurance, w); 
                        b1.add(mP);
                        break;
                }
            } else if (b2.size() <= 4) {
                switch (race) {
                    case 0: 
                        Autobot mA = new Autobot(name, endurance, endurance, w); 
                        b2.add(mA);
                        break;
                    case 1: 
                        Decepticon mD = new Decepticon(name, endurance, endurance, w); 
                        b2.add(mD);
                        break;
                    case 2:
                        Maximal mM = new Maximal(name, endurance, endurance, w); 
                        b2.add(mM);
                        break;
                    default:
                        Predacon mP = new Predacon(name, endurance, endurance, w); 
                        b2.add(mP);
                        break;
                }
            }
        }  
    }
    
    public static void printTeams() {
        System.out.println("Equipo 1:");
        for (Transformer t : b1) {
            System.out.println(t.toString());
        }

        System.out.println("\nEquipo 2:");
        for (Transformer t : b2) {
            System.out.println(t.toString());
        }
    }

    public static void checkState(int i, int n) {
        if (n == 1) {
            if (b1.get(i).getEndurance() < b1.get(i).getEnduranceInitial() * 0.5 && b1.get(i).isDefeated() == false) {
                b1.get(i).setState(true);
                System.out.println(b1.get(i).getName() + " ha sido derrotado");
            }
        } else {
            if (b2.get(i).getEndurance() < b2.get(i).getEnduranceInitial() * 0.5 && b2.get(i).isDefeated() == false) {
                b2.get(i).setState(true);
                System.out.println(b2.get(i).getName() + " ha sido derrotado");
            }
        }
    }

    public static int checkWinner() {
        int flag1 = 0, flag2 = 0;

        for (int i = 0; i < 5; i++) {
            if (b1.get(i).isDefeated() == true)
                flag1++;
            
            if (b2.get(i).isDefeated() == true)
                flag2++;
        }

        if (flag1 == 5) 
            return 2;
        else if (flag2 == 5)
            return 1;
        else 
            return 0;
    }
    
    public static void main(String[] args) {
        Random rand = new Random();
        int turn = rand.nextInt(2), attacker = 0, defender = 0;
        
        assignLeaders();
        makeTeams();

        System.out.println("Estado inicial de los equipos:");
        printTeams();
    
        // TODO: implementar los megatransformes
        while(checkWinner() == 0) {
            if (turn % 2 == 0) {
                System.out.println("\nTurno del equipo 1");

                do {
                    attacker = rand.nextInt(5);
                } while (b1.get(attacker).isDefeated());
                do {
                    defender = rand.nextInt(5);
                } while (b2.get(defender).isDefeated());

                System.out.println(b1.get(attacker).getName() + " ataca a " + b2.get(defender).getName());
                b1.get(attacker).attack(b2.get(defender), b1, b2);
                checkState(defender, 2);
            } else {
                System.out.println("\nTurno del equipo 2");
                
                do {
                    attacker = rand.nextInt(5);
                } while (b2.get(attacker).isDefeated());
                do {
                    defender = rand.nextInt(5);
                } while (b1.get(defender).isDefeated());
                
                System.out.println(b2.get(attacker).getName() + " ataca a " + b1.get(defender).getName());
                b2.get(attacker).attack(b1.get(defender), b1, b2);
                checkState(defender, 1);
            }
            turn++;
        }

        if(checkWinner() == 1)
            System.out.println("\nGanó el equipo 1");
        else 
            System.out.println("\nGanó el equipo 2");

        System.out.println("\nEstado final de los equipos:");
        printTeams();
    }
}
