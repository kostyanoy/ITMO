package lab4.myQuest.items

import lab4.functionality.ActionFactory
import lab4.functionality.Item
import lab4.myQuest.locations.Corner

class Chair : Item("Стул", { "Деревянный стул. Удобный, чтобы сидеть, если бы это было возможно сейчас." }, true) {
    init {
        actions.add(
            ActionFactory().changeLocation(
                "Схватить стул",
                { "${it.name} ухватился рукой за стул. Это ему, однако ж, не помогло удержаться на месте. В следующее мгновение он уже снова был в воздухе, и притом вместе со стулом в руках. Отлетев в угол комнаты, ${it.name} ударился спиной о стену, отскочил от нее, словно мячик, и полетел к противоположной стене" },
                Corner(), true
            )
        )
    }
}