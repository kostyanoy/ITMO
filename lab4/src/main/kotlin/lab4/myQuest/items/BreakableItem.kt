package lab4.myQuest.items

import lab4.functionality.ActionFactory
import lab4.functionality.Description
import lab4.functionality.Item

class BreakableItem(name: String, description: Description) : Item(name, description) {
    init {
        actions.add(
            ActionFactory().changeNameDescription("Разбить",
                { "${it.name} задевает что-то своим телом. Бедная $name" },
                "Осколки",
                { "Разбитые остатки какого-то предмета" })
        )
    }
}
