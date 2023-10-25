import 'AbstractAnimal.dart';

class Bird extends AbstractAnimal {
  Bird(String name, int year) : super(name, year, 3);

  @override
  String move() {
    return "fly";
  }

  @override
  String breathe() {
    return "lungs";
  }

  @override
  String reproduce() {
    return "eggs";
  }
}
