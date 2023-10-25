import AbstractAnimal

class Mammal(name: String, year: Int) : AbstractAnimal(name, year) {
    override fun move(): String {
        return "walk"
    }

    override fun breathe(): String {
        return "lungs"
    }

    override fun reproduce(): String {
        return "live births"
    }

    override fun getName(): String {
        return super.getName()
    }
}
