package src.battle;

public class DefWeapons extends Weapons {
    private int defense;    

    public DefWeapons(String name, int defense) {
        setName(name);
        setDefense(defense);
    }

    // Setters
    public void setDefense(int defense) {
        this.defense = defense;
    }

    // Getters
    public int getDefense() {
        return defense;
    }
}