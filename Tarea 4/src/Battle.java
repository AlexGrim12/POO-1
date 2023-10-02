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
        w1.add(new AtkWeapons("Espada de los prime", 12));
        w1.add(new AtkWeapons("Hacha de Energon", 15));
        Transformer leader1 = (Transformer) new Autobot("Optimus Prime", 120, 120, w1);

        ArrayList<Weapons> w2 = new ArrayList<Weapons>();
        w2.add(new AtkWeapons("Taladro cybertroiano", 9));
        Transformer leader2 = (Transformer) new Predacon("Razorclaw", 100, 100, w2);

        b1.add(leader1);
        b2.add(leader2);
    }

    public static void makeTeams() {
        Random rand = new Random();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Weapons> atkWeapons = new ArrayList<Weapons>();
        ArrayList<Weapons> defWeapons = new ArrayList<Weapons>();
        
        names.add("Adrian");
        names.add("Bruno");
        names.add("Carlos");
        names.add("David");
        names.add("Eduardo");
        names.add("Fernando");
        names.add("Gabriel");
        names.add("Juan");

        atkWeapons.add(new AtkWeapons("Canion de ion", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Canion laser", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Golpe de energia", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Rayo de calor", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Canion de plasma", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Canion de rayos", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Golpe de fuerza", rand.nextInt(6) + 10));
        atkWeapons.add(new AtkWeapons("Rayo de congelacion", rand.nextInt(6) + 10));
        
        defWeapons.add(new DefWeapons("Escudo de energíi", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Campo de fuerza", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Bombas de humo", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Blindaje sonico", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Blindaje electromagnetico", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Granada de Anulacion", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Disruptor de Campos", rand.nextInt(6) + 8));
        defWeapons.add(new DefWeapons("Escudo de examenes ;)", rand.nextInt(6) + 8));
        
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
        for (Transformer t : b1) 
            System.out.println(t.toString());

        System.out.println("\nEquipo 2:");
        for (Transformer t : b2)
            System.out.println(t.toString());
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

        for (int i = 0; i < b1.size(); i ++) {
            if (b1.get(i).isDefeated() == true)
                flag1++;
        }

        for (int i = 0; i < b2.size(); i++) {
            if (b2.get(i).isDefeated() == true)
                flag2++;
        }

        if (flag1 == b1.size()) 
            return 2;
        else if (flag2 == b2.size())
            return 1;
        else 
            return 0;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int turn = rand.nextInt(2), attacker = 0, defender = 0, nTurns = 0;
        boolean b1CanFusion = false, b2CanFusion = false;

        assignLeaders();
        makeTeams();

        System.out.println("Estado inicial de los equipos:");
        printTeams();
    
        while(checkWinner() == 0) {
            boolean flag = false;
            if (turn % 2 == 0) {
                System.out.println("\nTurno del equipo 1");

                do {
                    attacker = rand.nextInt(b1.size());
                } while (b1.get(attacker).isDefeated());
                do {
                    defender = rand.nextInt(b2.size());
                } while (b2.get(defender).isDefeated());
                
                b1CanFusion = b1.get(0).teamCanFusion(b1);
                int r = rand.nextInt(10) + 1;
                if (attacker != 0 && b1CanFusion && b1.get(attacker).canFusion() && r % 3 == 0) {
                    for (int t = 0; t < b1.size(); t ++) {
                        if (!b1.get(t).isDefeated() && b1.get(t).canFusion() && t != attacker && t != 0) {
                            b1.get(t).fusion(b1, attacker, t);
                            flag = true;
                            break;
                        }
                    }
                }
                
                if (!flag) {
                    System.out.println(b1.get(attacker).getName() + " ataca a " + b2.get(defender).getName());
                    b1.get(attacker).attack(b2.get(defender), b1, b2);
                    checkState(defender, 2);
                }
            } else {
                System.out.println("\nTurno del equipo 2");

                do {
                    attacker = rand.nextInt(b2.size());
                } while (b2.get(attacker).isDefeated());
                do {
                    defender = rand.nextInt(b1.size());
                } while (b1.get(defender).isDefeated());
                
                b2CanFusion = b2.get(0).teamCanFusion(b2);
                int r = rand.nextInt(10) + 1; 
                if (attacker != 0 && b2CanFusion && b2.get(attacker).canFusion() && r % 3 == 0) {
                    for (int t = 0; t < b2.size(); t ++) {
                        if (!b2.get(t).isDefeated() && b2.get(t).canFusion() && t != attacker && t != 0) {
                            b2.get(t).fusion(b2, attacker, t);
                            flag = true;
                            break;
                        }
                    }
                }
                
                if (!flag) {
                    System.out.println(b2.get(attacker).getName() + " ataca a " + b1.get(defender).getName());
                    b2.get(attacker).attack(b1.get(defender), b2, b1);
                    checkState(defender, 1);
                }
            }
            turn++;
            nTurns++;
        }

        if(checkWinner() == 1)
        System.out.println("\nGano el equipo 1");
        else 
        System.out.println("\nGano el equipo 2");
        
        System.out.println("\nLa batalla acabo en " + nTurns + " turnos");
        System.out.println("\nEstado final de los equipos:");
        printTeams();
    }
}
