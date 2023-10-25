interface LifeForm {
    fun eat(quantity: Int)
    fun getHunger(): Int
    fun getYear(): Int
    fun move(): String
    fun breathe(): String
    fun reproduce(): String
    fun getName(): String
}
