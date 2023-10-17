import java.util.ArrayList;
import java.util.List;

public class Vida {
    public static void main(String[] args) {
        List<LifeForm> animals = new ArrayList<LifeForm>();
        animals.add(new Mammal("Panda", 1869));
        animals.add(new Mammal("Zebra", 1778));
        animals.add(new Mammal("Koala", 1816));
        animals.add(new Mammal("Sloth", 1804));
        animals.add(new Mammal("Armadillo", 1758));
        animals.add(new Mammal("Raccoon", 1758));
        animals.add(new Mammal("Bigfoot", 2021));

        animals.add(new Bird("Toucan", 1758));
        animals.add(new Bird("Swan", 1758));
        animals.add(new Bird("Parrot", 1824));
        animals.add(new Bird("Peacock", 1821));
        
        animals.add(new Fish("Salmon", 1758));
        animals.add(new Fish("Catfish", 1817));
        animals.add(new Fish("Perch", 1758));

        animals.sort((animal1, animal2) -> animal2.getYear() - animal1.getYear());
        animals.forEach(animal -> System.out.println(animal.getName() + " " + animal.getYear() + "\n"));

        System.out.println("ORDENADOS ALFABETICAMENTE");
        animals.sort((animal1, animal2) -> animal1.getName().compareTo(animal2.getName()));
        animals.forEach(animal -> System.out.println(animal.getName() + "\n"));

        System.out.println("ORDENADOS POR MOVIMIENTO");
        animals.sort((animal1, animal2) -> animal1.move().compareTo(animal2.move()));
        animals.forEach(animal -> System.out.println(animal.getName() + " " + animal.move() + "\n"));

        System.out.println("ORDENADOS POR RESPIRACION");
        animals.sort((animal1, animal2) -> animal1.breathe().compareTo(animal2.breathe()));
        animals.forEach(animal -> System.out.println(animal.getName() + " " + animal.breathe() + "\n"));
    }
}
