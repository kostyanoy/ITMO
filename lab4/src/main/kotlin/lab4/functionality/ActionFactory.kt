package lab4.functionality

class ActionFactory {
    fun changeName(name: String, description: Description, newName: String): Action {
        return Action(name, description, { _, o -> o.name = newName }, true)
    }

    fun changeDescription(name: String, description: Description, newDescription: Description): Action {
        return Action(name, description, { _, o -> o.description = newDescription }, true)
    }

    fun changeNameDescription(
        name: String,
        description: Description,
        newName: String,
        newDescription: Description
    ): Action {
        return Action(name, description, { _, o ->
            o.name = newName
            o.description = newDescription
        }, true)
    }

}