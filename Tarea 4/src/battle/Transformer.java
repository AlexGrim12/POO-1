package src.battle;

import java.util.ArrayList;
import java.util.Random;

public class Transformer {
    private String name;
    private String race;
    private String homePlanet;
    private int enduranceInitial; 
    private int endurance; 
    private boolean dead = false;
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

    public int getEndurance() {
        return this.endurance;
    }

    public ArrayList<Weapons> getWeapons() {
        return this.weapons;
    }

    // Methods
    public void getHit(int damage) {
        this.endurance -= damage;
    }

    public int basicAttack() {
        Random rand = new Random();
        int r = rand.nextInt(2);

        if (r == 0) 
            return 2;
        else 
            return 3;
    }

    public void attack(Transformer enemy) {
        Random random = new Random();
        int rAtk   = random.nextInt(100) + 1;
        int rDef = random.nextInt(100) + 1;
        int damageCount = 0;
        int defenseCount = 0;


        if (rAtk   <= 60) 
            damageCount = this.basicAttack();
        else if (rAtk <= 95) {
            int nAtkWeapons = 0;

            for (Weapons i: this.getWeapons()) {
                if (i instanceof AtkWeapons) {
                    nAtkWeapons++;
                }
            }
            //si tiene 2 armas de ataque se elige una al azar
            if (nAtkWeapons == 2) {
                int i = random.nextInt(2);
                AtkWeapons w = (AtkWeapons) this.getWeapons().get(i);
                
                damageCount = w.getDamage();
            } else if(nAtkWeapons == 1) {
                if (this.getWeapons().get(0) instanceof AtkWeapons) {
                    AtkWeapons w = (AtkWeapons) this.getWeapons().get(0);
                    damageCount = w.getDamage();
                }
                else {
                    AtkWeapons w = (AtkWeapons) this.getWeapons().get(1);
                    damageCount = w.getDamage();
                }
            }
        } else {
            for (int i = 0; i < 3; i ++)
                damageCount += this.basicAttack();
        }

        if (rDef <= 10) {
            int nDefWeapons = 0;

            for (Weapons i: enemy.getWeapons()) {
                if (i instanceof DefWeapons) {
                    nDefWeapons ++;
                }
            }
            //si tiene 2 armas de ataque se elige una al azar
            if (nDefWeapons == 2) {
                int i = random.nextInt(2);
                DefWeapons w = (DefWeapons) enemy.getWeapons().get(i);
                AtkWeapons w2 = (AtkWeapons) enemy.getWeapons().get(i);
                
                w.get
            } else if(nDefWeapons == 1) {
                if (this.getWeapons().get(0) instanceof DefWeapons) {
                    DefWeapons w = (DefWeapons) enemy.getWeapons().get(0);
                    defenseCount = w.getDefense();
                }
                else {
                    DefWeapons w = (DefWeapons) enemy.getWeapons().get(1);
                    defenseCount = w.getDefense();
                }
            }   
        }
    }

    public static int giveMatrixOfLeadership(ArrayList<Transformer> b1, ArrayList<Transformer> b2) {
        boolean dead = false;

        for (Transformer t : b1) {
            if (t.endurance < (t.enduranceInitial)*0.75)
                return -1;
            
            if (t.dead == true) 
                dead = true;
        }
        
        for (Transformer t : b2) {
            if (t.endurance < (t.enduranceInitial)*0.75)
                return -1;
            
            if (t.dead == true) 
                dead = true;
        }

        if (dead == false)
            return -1;
        else {
            Random rand = new Random();
            int n = rand.nextInt(2);
            Weapons matrixOfLeadership = new AtkWeapons();

            if (n == 0) 
                b1.get(0).setWeapon(matrixOfLeadership);
            else 
                b1.get(0).setWeapon(matrixOfLeadership);

            return 1;
        }
    }

    public String toString() {
        return "Name: " + name + "\nRace: " + race + "\nHome Planet: " + homePlanet + "\nEndurance: " + endurance;
    }
}
