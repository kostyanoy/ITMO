package lab4.myQuest.items

import lab4.functionality.ActionFactory
import lab4.functionality.Item

class BookShell : Item("Книжная полка", { "Полка с множеством книг." }) {
    init {
        actions.add(ActionFactory().changeDescription("Осмотреть", {
            "${it.name} врезался головой в книжную полку, отчего книги разлетелись в разные стороны."
        }, { "Теперь уже пустая полка" }))
    }
}