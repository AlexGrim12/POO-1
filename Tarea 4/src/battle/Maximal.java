package src.battle;

import java.util.ArrayList;

public class Maximal extends Transformer{
        public Maximal(String name, int enduranceInitial, int endurance, ArrayList<Weapons> weapons) {
        setName(name);
        setRace("Maximal");
        setHomePlanet("Cybertron");
        setEnduranceInitial(enduranceInitial);
        setEndurance(endurance);
        setWeapons(weapons);
    }
}
