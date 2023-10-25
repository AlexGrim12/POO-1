import Mammal
import Bird
import Fish
import AbstractAnimal
import LifeForm

fun main() {
    val animals: MutableList<AbstractAnimal> = mutableListOf()

    animals.add(Mammal("Panda", 1869))
    animals.add(Mammal("Zebra", 1778))
    animals.add(Mammal("Koala", 1816))
    animals.add(Mammal("Sloth", 1804))
    animals.add(Mammal("Armadillo", 1758))
    animals.add(Mammal("Raccoon", 1758))
    animals.add(Mammal("Bigfoot", 2021))

    animals.add(Bird("Pigeon", 1837))
    animals.add(Bird("Peacock", 1821))
    animals.add(Bird("Toucan", 1758))
    animals.add(Bird("Parrot", 1824))
    animals.add(Bird("Swan", 1758))

    animals.add(Fish("Salmon", 1758))
    animals.add(Fish("Catfish", 1817))
    animals.add(Fish("Perch", 1758))

    animals.sortByDescending { it.getYear() }
    animals.forEach { animal ->
        println("${animal.getName()} ${animal.getYear()}")
    }

    println("-------Alphabetical-----------")
    animals.sortBy { it.getName() }
    animals.forEach { animal ->
        println(animal.getName())
    }

    println("-------Movement-----------")
    animals.sortBy { it.move() }
    animals.forEach { animal ->
        println("${animal.getName()} ${animal.move()}")
    }

    println("-------Breathers-----------")
    animals.filter { it.breathe() == "lungs" }.forEach { animal ->
        println("${animal.getName()} ${animal.breathe()}")
    }

    println("-------Breathers in 1758-----------")
    animals.filter { it.breathe() == "lungs" && it.getYear() == 1758 }.forEach { animal ->
        println("${animal.getName()} ${animal.breathe()}")
    }
}
