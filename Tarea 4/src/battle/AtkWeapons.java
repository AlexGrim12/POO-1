package src.battle;

public class AtkWeapons extends Weapons {
    private int damage;
    
    public AtkWeapons(String name, int damage) {
        setName(name);
        setDamage(damage);
    }

    public AtkWeapons(String name) {
        setName(name);
    }

    // Setter 
    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Getter
    public int getDamage() {
        return this.damage;
    }
}
