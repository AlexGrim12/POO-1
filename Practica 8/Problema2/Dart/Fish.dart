import 'AbstractAnimal.dart';

class Fish extends AbstractAnimal {
  Fish(String name, int year) : super.namedYear(name, year);

  @override
  String move() {
    return "swim";
  }

  @override
  String breathe() {
    return "gills";
  }

  @override
  String reproduce() {
    return "eggs";
  }
}
