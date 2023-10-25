import 'AbstractAnimal.dart';

class Mammal extends AbstractAnimal {
  Mammal(String name, int year) : super.namedYear(name, year);

  @override
  String move() {
    return "walk";
  }

  @override
  String breathe() {
    return "lungs";
  }

  @override
  String reproduce() {
    return "live births";
  }
}
