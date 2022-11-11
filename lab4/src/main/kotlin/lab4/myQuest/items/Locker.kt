package lab4.myQuest.items

import lab4.functionality.ActionFactory
import lab4.functionality.Item
import lab4.myQuest.locations.Space

class Locker : Item("Шкаф", { "Здесь ${it.name} хранит коллекцию камней" }) {
    init {
        actions.add(
            ActionFactory().changeLocation(
                "Положить камень на нижнюю полку",
                { "Открыв шкаф, в котором ${it.name} хранил коллекцию минералов, он сунул лунный камень на нижнюю полочку, так как на верхних полках не обнаружилось ни одного свободного местечка.\nДля этого ${it.name} нагнулся, а нагнувшись, он снова почувствовал легкое головокружение." },
                Space()
            )
        )
    }
}