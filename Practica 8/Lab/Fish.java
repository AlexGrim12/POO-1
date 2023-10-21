public class Fish extends AbstractAnimal {
    Fish (String name, int year) {
        super(name, year);
    }

    public String move() {
        return "swim";
    }

    public String breathe() {
        return "gills";
    }

    public String reproduce() {
        return "eggs";
    }
}
