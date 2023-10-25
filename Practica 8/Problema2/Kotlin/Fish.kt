import AbstractAnimal

class Fish(name: String, year: Int) : AbstractAnimal(name, year) {
    override fun move(): String {
        return "swim"
    }

    override fun breathe(): String {
        return "gills"
    }

    override fun reproduce(): String {
        return "eggs"
    }

    override fun getName(): String {
        return super.getName()
    }
}