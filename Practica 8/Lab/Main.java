import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("ComparatorCombinators")
    public static void main(String[] args) {
        List<AbstractAnimal> animals = new ArrayList<>();
        animals.add(new Mammal("Panda", 1869));
        animals.add(new Mammal("Zebra",1778));
        animals.add(new Mammal("Koala",1816));
        animals.add(new Mammal("Sloth",1804));
        animals.add(new Mammal("Armadillo",1758));
        animals.add(new Mammal("Raccoon",1758));
        animals.add(new Mammal("Bigfoot",2021));

        animals.add(new Bird("Pigeon", 1837));
        animals.add(new Bird("Peacock",1821));
        animals.add(new Bird("Toucan",1758));
        animals.add(new Bird("Parrot",1824));
        animals.add(new Bird("Swan",1758));

        animals.add(new Fish("Salmon", 1758));
        animals.add(new Fish("Catfish", 1817));
        animals.add(new Fish("Perch", 1758));

        animals.sort((animal1, animal2) -> animal2.getYear() - animal1.getYear());
        animals.forEach(animal -> {
            System.out.println(animal.getName() + " " + animal.getYear());
        });

        System.out.println("\n-------Alphabetical-----------");
        animals.sort((animal1, animal2) -> animal1.getName().compareTo(animal2.getName()));
        animals.forEach(animal -> {
            System.out.println(animal.getName());
        });

        System.out.println("\n-------Movement-----------");
        animals.sort((animal1, animal2) -> animal1.move().compareTo(animal2.move()));
        animals.forEach(animal -> {
            System.out.println(animal.getName() + " " + animal.move());
        });

        System.out.println("\n-------Breathers-----------");
        animals.forEach(animal -> {
            if (animal.breathe().equals("lungs")) {
                System.out.println(animal.getName() + " " + animal.breathe());
            }
        });

        System.out.println("\n-------Breathers in 1758-----------");
        animals.forEach(animal -> {
            if (animal.breathe().equals("lungs") && animal.getYear() == 1758) {
                System.out.println(animal.getName() + " " + animal.breathe());
            }
        });
    }
}
