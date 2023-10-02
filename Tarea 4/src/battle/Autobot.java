package src.battle;

import java.util.ArrayList;

public class Autobot extends Transformer{
    public Autobot(String name, int enduranceInitial , int endurance, ArrayList<Weapons> weapons) {
        setName(name);
        setRace("Autobot");
        setHomePlanet("Cybertron");
        setEnduranceInitial(enduranceInitial);
        setEndurance(endurance);
        setWeapons(weapons);
    }
}
