package lab4.functionality

class ActionFactory {
    fun changeName(name: String, description: Description, newName: String): Action {
        return Action(name, description, { _, o -> o.name = newName }, true)
    }

    fun changeDescription(name: String, description: Description, newDescription: Description): Action {
        return Action(name, description, { _, o -> o.description = newDescription }, true)
    }

    fun changeNameDescription(
        name: String, description: Description, newName: String, newDescription: Description
    ): Action {
        return Action(name, description, { _, o ->
            o.name = newName
            o.description = newDescription
        }, true)
    }

    fun changeLocation(name: String, description: Description, location: Location, once: Boolean = false): Action {
        return Action(name, description, { p, _ -> p.enterLocation(location) }, once)
    }

    fun addItem(name: String, description: Description, item: Item): Action {
        return Action(name, description, { p, _ -> p.location.addItem(item) }, true)
    }

    fun addLocation(name: String, description: Description, location: Location): Action {
        return Action(name, description, { p, _ -> p.location.addOneWayLocation(location) })
    }

    fun addPlayerAction(name: String, description: Description, action: Action): Action {
        return Action(name, description, { p, _ -> p.actions.add(action) })
    }

    fun empty(name: String, description: Description): Action {
        return Action(name, description, { _, _ -> }, true)
    }

    fun end(name: String, description: Description): Action {
        return Action(name, description, {p, _ -> p.completedQuest = true})
    }

}