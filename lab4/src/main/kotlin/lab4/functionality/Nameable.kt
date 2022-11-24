package lab4.functionality

abstract class Nameable(
    var name: String,
    var description: Description
) {
    constructor(
        name: String,
        description: String
    ) : this(name, { description })
}