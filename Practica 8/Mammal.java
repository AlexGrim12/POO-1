public class Mammal extends AbstractAnimal {
    Mammal(String name, int year) {
        super(name, year);
    }

    public String move() {
        return "walk";
    }

    public String breathe() {
        return "lungs";
    }

    public String reproduce() {
        return "live births";
    }

    // public boolean sleep() {} 
}
