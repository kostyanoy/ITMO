package lab4.functionality

open class Item(
    name: String,
    description: Description,
    val isConsumable: Boolean = false
) : Actionable(name, description)