package lab4.myQuest.items

import lab4.functionality.Action
import lab4.functionality.Description
import lab4.functionality.Item

class Shell : Item("Шкаф", { "Шкаф для книг с открытой дверцей. Что он здесь делает?" }) {
    init {
        actions.add(
            Action(
                "Закрыть дверцу",
                { p -> p.name + " закрыл дверцу шкафа" },
                { _, o -> o.description = Description { "Шкаф для книг с закрытой дверцей." } },
                true
            )
        )
    }

}