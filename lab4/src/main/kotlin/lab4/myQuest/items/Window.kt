package lab4.myQuest.items

import lab4.functionality.ActionFactory
import lab4.functionality.Item

class Window : Item("Подоконник", { "Подоконник возле окна" }) {
    init {
        actions.add(ActionFactory().empty("Убрать книги") { "${it.name} считает, что надо убрать лунный камень в шкаф" })
        actions.add(
            ActionFactory().addItem(
                "Взять лунный камень", { "Этот лунный камень отлично подходит для коллекции" }, Locker()
            )
        )
    }
}