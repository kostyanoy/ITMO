package lab4.functionality

abstract class Location(name: String, description: Description) : Actionable(name, description) {
    val items = ArrayList<Item>()
    val locations = ArrayList<Location>()

    constructor(name: String, description: String) : this(name, { description })

    open fun enter(player: Player): String {
        return ""
    }

    // Fluent API or IDK
    fun addOneWayLocation(other: Location): Location {
        locations.add(other)
        return other
    }

    fun addBothWayLocation(other: Location): Location {
        other.locations.add(this)
        locations.add(other)
        return other
    }

    fun addItem(item: Item): Location {
        items.add(item)
        return this
    }
}