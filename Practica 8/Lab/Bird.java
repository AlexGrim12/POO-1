public class Bird extends AbstractAnimal {
    Bird (String name, int year) {
        super(name, year, 3);
    }

    public String move() {
        return "fly";
    }

    public String breathe() {
        return "lungs";
    }

    public String reproduce() {
        return "eggs";
    }
}
