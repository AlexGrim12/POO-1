package src.battle;

import java.util.ArrayList;
import java.util.Random;

public class Autobot extends Transformer{
    public Autobot(String name, int endurance, ArrayList<Weapons> weapons) {
        setName(name);
        setRace("Autobot");
        setHomePlanet("Cybertron");
        setEndurance(endurance);
        setEnduranceInitial(endurance);
        setWeapons(weapons);
    }

    // Methods
    
}
