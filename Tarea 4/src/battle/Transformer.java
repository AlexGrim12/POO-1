package src.battle;

import java.util.ArrayList;
import java.util.Random;

public class Transformer implements MegaTransformers {
    private String name;
    private String race;
    private String homePlanet;
    private int enduranceInitial; 
    private int endurance; 
    private ArrayList<Weapons> weapons = new ArrayList<Weapons>();
    private boolean defeated = false;
    private boolean mol = false;

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }

    public void setEnduranceInitial(int enduranceInitial) {
        this.enduranceInitial = enduranceInitial;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setWeapon(Weapons weapon) {
        this.weapons.add(weapon);
    }

    public void setWeapons(ArrayList<Weapons> weapons) {
        this.weapons = weapons;
    }

    public void setState(boolean defeated) {
        this.defeated = defeated;
    }

    public void setMlf(boolean mol) {
        this.mol = mol;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public String getHomePlanet() {
        return this.homePlanet;
    }

    public int getEnduranceInitial() {
        return this.enduranceInitial;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public ArrayList<Weapons> getWeapons() {
        return this.weapons;
    }

    public boolean isDefeated() {
        return this.defeated;
    }

    public boolean getMlf() {
        return this.mol;
    }

    // Methods
    public void getHit(int damage) {
        this.endurance -= damage;
    }

    public int basicAttack() {
        Random rand = new Random();
        int r = rand.nextInt(2);

        if (r == 0) 
            return 8;
        else 
            return 12;
    }

    public void attack(Transformer enemy, ArrayList<Transformer> b1, ArrayList<Transformer> b2) {
        Random random = new Random();
        int rAtk   = random.nextInt(100) + 1;
        int rDef = random.nextInt(100) + 1;
        int damageCount = 0;
        int defenseCount = 0;

        if (rAtk   <= 60) {
            damageCount = this.basicAttack();
            System.out.println(this.getName() + " usa ataque basico");
        }
        else if (rAtk <= 95) {
            int nAtkWeapons = 0;

            for (Weapons i: this.getWeapons()) {
                if (i instanceof AtkWeapons) {
                    nAtkWeapons++;
                }
            }
     
            if (nAtkWeapons == 2) {
                int i = random.nextInt(2);
                AtkWeapons w = (AtkWeapons) this.getWeapons().get(i);
                System.out.println(this.getName() + " usa " + w.getName());
                damageCount = w.getDamage();
            } else {
                AtkWeapons w = (AtkWeapons) this.getWeapons().get(0);
                System.out.println(this.getName() + " usa " + w.getName());
                damageCount = w.getDamage();
            }
        } else {
            System.out.println(this.getName() + " usa combo de 3 golpes basicos");
            for (int i = 0; i < 3; i ++)
                damageCount += this.basicAttack();
        }

        if (rDef <= 10) {
            int nDefWeapons = 0;

            for (Weapons i: enemy.getWeapons()) {
                if (i instanceof DefWeapons) {
                    nDefWeapons++;
                }
            }

            if (nDefWeapons == 1) {
                DefWeapons w = (DefWeapons) enemy.getWeapons().get(1);
                System.out.println(enemy.getName() + " usa " + w.getName());
                defenseCount = w.getDefense();
            } else
                System.out.println(enemy.getName() + " no tiene armas de defensa"); 
        } else if (rDef <= 12) {
            defenseCount = damageCount / 2;
            System.out.println(enemy.getName() + " usa unidades de energon");
        } else 
            System.out.println(enemy.getName() + " no se defiende");

        System.out.print(this.getName() + " ataca a " + enemy.getName() + " con " + damageCount + " de daño ");
        System.out.println("y " + enemy.getName() + " se defiende con " + defenseCount + " de defensa");
        if (damageCount - defenseCount > 0)
            enemy.getHit(damageCount - defenseCount);
        System.out.println(enemy.getName() + " queda con " + enemy.getEndurance() + " de resistencia");

        giveMol(b1, b2);
    }

    private static void giveMol(ArrayList<Transformer> b1, ArrayList<Transformer> b2) {
        // TODO Cambiar las condiciones para dar la matriz de liderazgo
        
        boolean defeated = false;
        
        for (Transformer t : b1) {
            if (t.endurance < (t.enduranceInitial)*0.75){
                System.out.println("Menos de 75% de resistencia");
                return;
            }

            if (t.defeated)
                defeated = true;
        }
        
        for (Transformer t : b2) {
            if (t.endurance < (t.enduranceInitial)*0.75) {
                System.out.println("Menos de 75% de resistencia");
                return;
            }
            
            if (t.defeated) 
                defeated = true;
        }

        if (!defeated) {
            System.out.println("Ningun transformer ha sido derrotado");
            return;
        }
            
        if (b1.get(0).getMlf() || b2.get(0).getMlf()) {
            System.out.println("Ya se ha usado la Matriz de Liderazgo");
            return;
        }

        Random rand = new Random();
        int n = rand.nextInt(2);
        Weapons mol = new AtkWeapons("Matriz de Liderazgo");

        if (n == 0) {
            b1.get(0).setMlf(true);
            AtkWeapons w = (AtkWeapons) b1.get(0).getWeapons().get(0);
            System.out.println(w.getDamage());
            b1.get(0).useMol();
            System.out.println(b1.get(0).getName() + " obtiene " + mol.getName() + " y la usa"); 
            System.out.println(w.getDamage());
        }   
        else {
            b2.get(0).setMlf(true);
            AtkWeapons w = (AtkWeapons) b2.get(0).getWeapons().get(0);
            System.out.println(w.getDamage());
            b2.get(0).useMol();
            System.out.println(b2.get(0).getName() + " obtiene " + mol.getName() + " y la usa");
            System.out.println(w.getDamage());
        } 
    }

    private void useMol() {
        this.setEndurance(enduranceInitial);
        for (Weapons w : this.getWeapons()) {
            if (w instanceof AtkWeapons) {
                AtkWeapons a = (AtkWeapons) w;
                a.setDamage(a.getDamage() * 2);
            }
        }
    }

    public boolean canTransform(Transformer t1, Transformer t2) {
        if (t1 instanceof Autobot && t2 instanceof Decepticon)
            return false;
        else 
            return true;
    }

    public void transform(ArrayList<Transformer> b, int i, int j) {
        String name = b.get(i).getName() + " y " + b.get(j).getName();
        String race = b.get(i).getRace() + " y " + b.get(j).getRace();
        int enduranceInitial = b.get(i).getEnduranceInitial() * b.get(j).getEnduranceInitial();
        int endurance = b.get(i).getEndurance() * b.get(j).getEndurance();
        ArrayList<Weapons> weapons = new ArrayList<Weapons>();
        
        for (Weapons w : b.get(i).getWeapons()) {
            weapons.add(w);
        }

        for (Weapons w : b.get(j).getWeapons()) {
            weapons.add(w);
        }

        b.remove(i);
        b.remove(j);

        //Constructor
        Transformer t = new Transformer();
        t.setName(name);
        t.setRace(race);
        t.setHomePlanet("Cybertron");
        t.setEnduranceInitial(enduranceInitial);
        t.setEndurance(endurance);
        t.setWeapons(weapons);
        
        b.add(t);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("Nombre: " + this.name);
        s.append(", Raza: " + this.race);
        s.append(", Mundo de origen: " + this.homePlanet);
        s.append(", Resistencia: " + this.endurance);
        s.append(", Armas: ");
        for (Weapons w : this.weapons)
            s.append(w.getName() + ", ");

        return s.toString();
    }
}
