import 'LifeForm.dart';

abstract class AbstractAnimal implements LifeForm {
  static int maxId = 0;
  late int hunger;
  late String name;
  late int id;
  late int year;

  AbstractAnimal(String name, int year, int hunger) {
    this.hunger = hunger;
    this.name = name;
    this.year = year;
    maxId++;
    id = maxId;
  }

  AbstractAnimal.namedYear(String name, int year) : this(name, year, 0);

  void eat(int quantity) {
    hunger -= quantity;
    hunger = hunger < 0 ? 0 : hunger;
  }

  String getName() {
    return name;
  }

  int getHunger() {
    return hunger;
  }

  int getId() {
    return id;
  }

  int getYear() {
    return year;
  }

  String move();
  String breathe();
  String reproduce();
}
