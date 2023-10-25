import 'AbstractAnimal.dart';
import 'Bird.dart';
import 'Fish.dart';
import 'Mammal.dart';

void main() {
  List<AbstractAnimal> animals = [];
  animals.add(Mammal("Panda", 1869));
  animals.add(Mammal("Zebra", 1778));
  animals.add(Mammal("Koala", 1816));
  animals.add(Mammal("Sloth", 1804));
  animals.add(Mammal("Armadillo", 1758));
  animals.add(Mammal("Raccoon", 1758));
  animals.add(Mammal("Bigfoot", 2021));

  animals.add(Bird("Pigeon", 1837));
  animals.add(Bird("Peacock", 1821));
  animals.add(Bird("Toucan", 1758));
  animals.add(Bird("Parrot", 1824));
  animals.add(Bird("Swan", 1758));

  animals.add(Fish("Salmon", 1758));
  animals.add(Fish("Catfish", 1817));
  animals.add(Fish("Perch", 1758));

  animals.sort((animal1, animal2) => animal2.getYear() - animal1.getYear());
  animals.forEach((animal) {
    print('${animal.getName()} ${animal.getYear()}');
  });
  print("\n-------Alphabetical-----------");
  animals.sort(
      (animal1, animal2) => animal1.getName().compareTo(animal2.getName()));
  animals.forEach((animal) {
    print('${animal.getName()}');
  });

  print("\n-------Movement-----------");
  animals.sort((animal1, animal2) => animal1.move().compareTo(animal2.move()));
  animals.forEach((animal) {
    print('${animal.getName()} ${animal.move()}');
  });

  print("\n-------Breathers-----------");
  animals.forEach((animal) {
    if (animal.breathe() == "lungs") {
      print('${animal.getName()} ${animal.breathe()}');
    }
  });

  print("\n-------Breathers in 1758-----------");
  animals.forEach((animal) {
    if (animal.breathe() == "lungs" && animal.getYear() == 1758) {
      print('${animal.getName()} ${animal.breathe()}');
    }
  });
}
