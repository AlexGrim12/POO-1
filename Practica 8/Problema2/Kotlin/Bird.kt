import AbstractAnimal

class Bird(name: String, year: Int) : AbstractAnimal(name, year, 3) {
    override fun move(): String {
        return "fly"
    }

    override fun breathe(): String {
        return "lungs"
    }

    override fun reproduce(): String {
        return "eggs"
    }

    override fun getName(): String {
        return super.getName()
    }    
}
