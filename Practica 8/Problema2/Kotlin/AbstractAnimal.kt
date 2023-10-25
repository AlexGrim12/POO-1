import LifeForm

abstract class AbstractAnimal : LifeForm {
    companion object {
        private var maxId = 0
    }

    private var hunger = 0
    private val name: String
    private val id: Int
    private val year: Int

    constructor(name: String, year: Int, hunger: Int) {
        maxId++
        this.id = maxId
        this.hunger = hunger
        this.year = year
        this.name = name
    }

    constructor(name: String, year: Int) : this(name, year, 0)
    
    override fun eat(quantity: Int) {
        hunger -= quantity
        hunger = if (hunger < 0) 0 else hunger
    }

    override fun getHunger(): Int {
        return hunger
    }

    override fun getYear(): Int {
        return year
    }

    override fun getName(): String {
        return name
    }
    
    abstract override fun move(): String
    abstract override fun breathe(): String
    abstract override fun reproduce(): String
}
