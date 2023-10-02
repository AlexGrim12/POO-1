package src.battle;

import java.util.ArrayList;

public class Predacon extends Transformer{
        public Predacon(String name, int enduranceInitial, int endurance, ArrayList<Weapons> weapons) {
        setName(name);
        setRace("Predacon");
        setHomePlanet("Cybertron");
        setEnduranceInitial(enduranceInitial);
        setEndurance(endurance);
        setWeapons(weapons);
    }
}
