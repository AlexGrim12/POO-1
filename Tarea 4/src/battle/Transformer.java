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
        } else if (rAtk <= 95) {
            ArrayList<AtkWeapons> atkOptions = new ArrayList<AtkWeapons>();

            for (Weapons i: this.getWeapons()) {
                if (i instanceof AtkWeapons)
                    atkOptions.add((AtkWeapons) i);
            }
     
            int r = random.nextInt(atkOptions.size());
            damageCount = atkOptions.get(r).getDamage();
            System.out.println(this.getName() + " usa " + atkOptions.get(r).getName());
        } else {
            System.out.println(this.getName() + " usa combo de 3 golpes basicos");
            for (int i = 0; i < 3; i ++)
                damageCount += this.basicAttack();
        }

        if (rDef <= 10) {
            ArrayList<DefWeapons> defOptions = new ArrayList<DefWeapons>();

            for (Weapons i: enemy.getWeapons()) {
                if (i instanceof DefWeapons) 
                    defOptions.add((DefWeapons) i);
            }
            
            if (defOptions.size() == 0) 
                System.out.println(enemy.getName() + " no tiene armas de defensa");
            else {
                int r = random.nextInt(defOptions.size());
                defenseCount = defOptions.get(r).getDefense();
                System.out.println(enemy.getName() + " usa " + defOptions.get(r).getName());
            }
            
        } else if (rDef <= 12) {
            defenseCount = damageCount / 2;
            System.out.println(enemy.getName() + " usa unidades de energon");
        } else 
            System.out.println(enemy.getName() + " no se defiende");

        System.out.print(this.getName() + " ataca a " + enemy.getName() + " con " + damageCount + " de danio ");
        System.out.println("y " + enemy.getName() + " se defiende con " + defenseCount + " de defensa");
        if (damageCount - defenseCount > 0)
            enemy.getHit(damageCount - defenseCount);
        System.out.println(enemy.getName() + " queda con " + enemy.getEndurance() + " de resistencia");

        giveMol(b1, b2);
    }

    private static void giveMol(ArrayList<Transformer> b1, ArrayList<Transformer> b2) {
        // Se cambiaron las condiciones para que la matriz se use mas seguido
        boolean defeated1 = false;
        boolean defeated2 = false;
        
        // No da la matriz si ambos lideres estan derrotados
        if (b1.get(0).isDefeated() && b2.get(0).isDefeated())
            return;    

        // No da la matriz si alguno de los dos transformers ya la uso
        if (b1.get(0).getMlf() || b2.get(0).getMlf())
            return;

        // No da la matriz si alguno de los dos lideres tiene mas de 75% de resistencia
        if (b1.get(0).getEndurance() > b1.get(0).getEnduranceInitial()*0.75)
            return;
        
        if (b2.get(0).getEndurance() > b2.get(0).getEnduranceInitial()*0.75)
            return;

        // La da si cada equipo tiene al menos un transformer derrotado
        for (Transformer t : b1) {
            if (t.isDefeated())
                defeated1 = true;
        }
        
        for (Transformer t : b2) {
            if (t.isDefeated())
                defeated2 = true;
        }
 
        if (!defeated1 || !defeated2)
            return;
            
        Weapons mol = new AtkWeapons("Matriz de Liderazgo");
        if (b1.get(0).isDefeated()) {
            b2.get(0).setMlf(true);
            b2.get(0).useMol();
            System.out.println(b2.get(0).getName() + " obtiene " + mol.getName() + " y la usa");
        } else if (b2.get(0).isDefeated()) {
            b1.get(0).setMlf(true);
            b1.get(0).useMol();
            System.out.println(b1.get(0).getName() + " obtiene " + mol.getName() + " y la usa"); 
        } else {
            Random rand = new Random();
            int n = rand.nextInt(2);

            if (n == 0) {
                b1.get(0).setMlf(true);
                b1.get(0).useMol();
                System.out.println(b1.get(0).getName() + " obtiene " + mol.getName() + " y la usa"); 
            } else {
                b2.get(0).setMlf(true);
                b2.get(0).useMol();
                System.out.println(b2.get(0).getName() + " obtiene " + mol.getName() + " y la usa");
            }
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

    public boolean teamCanFusion(ArrayList<Transformer> b) {
        int count = 0;

        for (Transformer t : b) {
            if (t instanceof Maximal)
                count++;
            
            if (t instanceof Predacon)
                count++;
        }

        if (count >= 2)
            return true;
        else 
            return false;
    }

    public boolean canFusion() {
        return this instanceof Maximal || this instanceof Predacon;
    }

    public void fusion(ArrayList<Transformer> b, int i, int j) {
        System.out.println(b.get(i).getName() + " y " + b.get(j).getName() + " se fusionan en un MegaTransformer");

        String name = b.get(i).getName() + " y " + b.get(j).getName();
        String race = "MegaTransformer";
        int enduranceInitial = b.get(i).getEnduranceInitial() + b.get(j).getEnduranceInitial();
        int endurance = b.get(i).getEndurance() + b.get(j).getEndurance();
        ArrayList<Weapons> weapons = new ArrayList<Weapons>();
        
        for (Weapons w : b.get(i).getWeapons())
            weapons.add(w);

        for (Weapons w : b.get(j).getWeapons())
            weapons.add(w);

        Transformer b1 = b.get(i);
        Transformer b2 = b.get(j);

        b.remove(b1);
        b.remove(b2);

        //Constructor
        Maximal t = new Maximal();
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
