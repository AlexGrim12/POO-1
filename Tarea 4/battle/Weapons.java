package battle;

public abstract class Weapons {
    String name;
    String type;

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
