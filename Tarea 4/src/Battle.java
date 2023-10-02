package src;
import src.battle.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Battle {
    static ArrayList<Transformer> b1 = new ArrayList<Transformer>();
    static ArrayList<Transformer> b2 = new ArrayList<Transformer>();
    
    public static void assignLeaders() {
        ArrayList<Weapons> weapons = new ArrayList<Weapons>();

        weapons.add(new AtkWeapons("Espada de los prime", 8));
        weapons.add(new AtkWeapons("Hacha de Energon", 10));

        Transformer leader1 = new Autobot("Optimus Prime", 120, 120, weapons);

        weapons.clear();

        weapons.add(new AtkWeapons("Taladro cybertroiano", 6));

        Transformer leader2 = new Predacon("Razorclaw", 100, 100, weapons);

        b1.add(leader1);
        b2.add(leader2);
    }

    public static void makeTeams() {
        Random rand = new Random();
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Adrian", "Bruno", "Carlos", "David", "Eduardo", "Fernando", "Gabriel", "Juan"));
        ArrayList<Weapons> atkWeapons = new ArrayList<Weapons>();
        ArrayList<Weapons> defWeapons = new ArrayList<Weapons>();
        
        atkWeapons.add(new AtkWeapons("Cañón de ion", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Cañón láser", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Golpe de energía", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Rayo de calor", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Cañón de plasma", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Cañón de rayos", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Golpe de fuerza", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Rayo de congelación", rand.nextInt(6) + 10));
        
        defWeapons.add(new DefWeapons("Escudo de energía", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Campo de fuerza", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Bombas de humo", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Blindaje sónico", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Blindaje electromagnético", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Granada de Anulación", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Disruptor de Campos", rand.nextInt(6) + 10));
        defWeapons.add(new DefWeapons("Escudo de examenes ;)", rand.nextInt(6) + 10));
        
        for (int i = 0; i < 8; i++) {
            ArrayList<Weapons> w = new ArrayList<Weapons>(2);
            int iName = rand.nextInt(names.size());
            int nWeapons = rand.nextInt(atkWeapons.size());
            int endurance = rand.nextInt(71) + 50;

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
    
            w.clear();
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

    public static void checkState() {
        for (Transformer t : b1) {
            if (t.getEndurance() < (t.getEnduranceInitial())*0.5 && t.isDefeated() == false) {
                t.setState(true);
                System.out.println(t.getName() + " ha sido derrotado");
                break;
            }
        }

        for (Transformer t : b2) {
            if (t.getEndurance() < (t.getEnduranceInitial())*0.5 && t.isDefeated() == false) {
                t.setState(true);
                System.out.println(t.getName() + " ha sido derrotado");
                break;
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
        int turn = rand.nextInt(2), i = 0, j = 0;
        
        assignLeaders();
        makeTeams();
        System.out.println(b1.get(b1.size() - 1).getWeapons().size());
        System.out.println(b1.get(b1.size() - 1).getWeapons().get(0).getName());
        // printTeams();
        

        // while(checkWinner() == 0) {
        //     if (turn % 2 == 0) {
        //         System.out.println("\nTurno del equipo 1");
        //         do {
        //             i = rand.nextInt(5);
        //             j = rand.nextInt(5);
        //         } while (b1.get(i).isDefeated() == true && b2.get(j).isDefeated() == true);
                
        //         System.out.println(b1.get(i).getName() + " atatca a " + b2.get(j).getName());
        //         b1.get(i).attack(b2.get(j));
        //     } else {
        //         System.out.println("\nTurno del equipo 2");
        //         do {
        //             i = rand.nextInt(5);
        //             j = rand.nextInt(5);
        //         } while (b1.get(i).isDefeated() == true && b2.get(j).isDefeated() == true);
                
        //         System.out.println(b2.get(i).getName() + " atatca a " + b1.get(j).getName());
        //         b2.get(i).attack(b1.get(j));
        //     }
        //     turn++;
        //     checkState();
        // }

        // if(checkWinner() == 1)
        //     System.out.println("\nGanó el equipo 1");
        // else 
        //     System.out.println("Ganó el equipo 2");

        // System.out.println("\nEstado final de los equipos:");
        // printTeams();
    }
}