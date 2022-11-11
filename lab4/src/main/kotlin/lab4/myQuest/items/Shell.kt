package lab4.myQuest.items

import lab4.functionality.ActionFactory
import lab4.functionality.Item

class Shell : Item("Шкаф", { "Шкаф для книг с открытой дверцей. Что он здесь делает?" }) {
    init {
        actions.add(
            ActionFactory().changeDescription(
                "Закрыть дверцу",
                { p -> p.name + " закрыл дверцу шкафа" },
                { "Шкаф для книг с закрытой дверцей." })
        )
    }

}