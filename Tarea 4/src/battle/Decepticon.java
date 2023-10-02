package src.battle;

import java.util.ArrayList;

public class Decepticon extends Transformer{
    public Decepticon(String name, int enduranceInitial, int endurance, ArrayList<Weapons> weapons) {
        setName(name);
        setRace("Decepticon");
        setHomePlanet("Cybertron");
        setEnduranceInitial(enduranceInitial);
        setEndurance(endurance);
        setWeapons(weapons);
    }
}
