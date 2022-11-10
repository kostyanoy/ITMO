package lab4.functionality

abstract class Location(name: String, description: Description) : Actionable(name, description) {
    val items = ArrayList<Item>()
    val locations = ArrayList<Location>()

    constructor(name: String, description: String) : this(name, { description })

    abstract fun enter(player: Player): String

    fun connect(loc: Location) {
        loc.locations.add(this)
        locations.add(loc)
    }
}