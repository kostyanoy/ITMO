package lab4.functionality

abstract class Actionable(
    name: String,
    description: Description
) : Nameable(name, description) {

    val actions: ArrayList<Action> = ArrayList()

    constructor(
        name: String,
        description: String
    ) : this(name, { description })

}