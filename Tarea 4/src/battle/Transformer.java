package src.battle;

import java.util.ArrayList;
import java.util.Random;

public class Transformer implements MegaTransformers {
    private String name;
    private String race;
    private String homePlanet;
    private int enduranceInitial; 
    private int endurance; 
    private boolean defeated = false;
    private ArrayList<Weapons> weapons = new ArrayList<Weapons>();

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

    // Methods
    public void getHit(int damage) {
        this.endurance -= damage;
    }

    public int basicAttack() {
        Random rand = new Random();
        int r = rand.nextInt(2);

        if (r == 0) 
            return 4;
        else 
            return 6;
    }

    public void attack(Transformer enemy) {
        Random random = new Random();
        int rAtk   = random.nextInt(100) + 1;
        int rDef = random.nextInt(100) + 1;
        int damageCount = 0;
        int defenseCount = 0;

        System.out.println(rAtk + "\t" + rDef);
        if (rAtk   <= 60) {
            damageCount = this.basicAttack();
            System.out.println(this.getName() + " usa ataque basico");
        }
        else if (rAtk <= 95) {
            AtkWeapons w = (AtkWeapons) this.getWeapons().get(0);
            System.out.println(this.getName() + " usa " + w.getName());          
            damageCount = w.getDamage();
        } else {
            System.out.println(this.getName() + " usa combo de 3 golpes basicos");
            for (int i = 0; i < 3; i ++)
                damageCount += this.basicAttack();
        }

        if (rDef <= 10) {
            DefWeapons w = (DefWeapons) enemy.getWeapons().get(1);
            System.out.println(enemy.getName() + " usa " + w.getName());
            defenseCount = w.getDefense();
        } else if (rDef <= 12) {
            defenseCount = damageCount / 2;
            System.out.println(enemy.getName() + " usa unidades de energon");
        } else 
            System.out.println(enemy.getName() + " no se defiende");

        System.out.print(this.getName() + " ataca a " + enemy.getName() + " con " + damageCount + " de daño ");
        System.out.println("y " + enemy.getName() + " se defiende con " + defenseCount + " de defensa");
        enemy.getHit(damageCount - defenseCount);
    }

    public static void giveMatrixOfLeadership(ArrayList<Transformer> b1, ArrayList<Transformer> b2) {
        boolean defeated = false;
        
        for (Transformer t : b1) {
            if (t.endurance < (t.enduranceInitial)*0.75)
                return;

            if (t.defeated)
                defeated = true;
        }
        
        for (Transformer t : b2) {
            if (t.endurance < (t.enduranceInitial)*0.75)
                return;
            
            if (t.defeated)
                defeated = true;
        }

        if (defeated)
            return;

        Random rand = new Random();
        int n = rand.nextInt(2);
        Weapons matrixOfLeadership = new AtkWeapons("Matrix of Leadership");

        if (n == 0) {
            b1.get(0).setWeapon(matrixOfLeadership);
            System.out.println(b1.get(0).getName() + " obtiene la Matrix of Leadership");
        }
        else {
            b2.get(0).setWeapon(matrixOfLeadership);
            System.out.println(b2.get(0).getName() + " obtiene la Matrix of Leadership");
        } 
    }

    private void useMatrixOfLeadership() {
        this.setEndurance(enduranceInitial);
        for (Weapons w : this.getWeapons()) {
            if (w instanceof AtkWeapons){
                AtkWeapons a = (AtkWeapons) w;
                a.setDamage(a.getDamage() * 2);
                this.weapons.remove(w);
                this.weapons.add(a);
            } else {
                DefWeapons d = (DefWeapons) w;
                d.setDefense(d.getDefense() * 2);
                this.weapons.remove(w);
                this.weapons.add(d);
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

        s.append("Nombre " + this.name);
        s.append(", Raza" + this.race);
        s.append(", Mundo de origen: " + this.homePlanet);
        s.append(", Resistencia: " + this.endurance);
        s.append(", Armas: " + this.weapons.size());
        // s.append(", Armas: " + this.weapons.get(0).getName() + ", " + this.weapons.get(1).getName());

        return s.toString();
    }
}
