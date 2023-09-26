package battle;

import java.util.ArrayList;

public class Transformer extends Weapons{
    private String leader;
    private String name;
    private String race;
    private String homePlanet;
    private int endurance; 
    private ArrayList<Weapons> weapons;

    // Setters
    public void setLeader(String leader) {
        this.leader = leader;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setWeapons(ArrayList<Weapons> weapons) {
        this.weapons = weapons;
    }
    
    // Getters
    public String getLeader() {
        return this.leader;
    }

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
}
