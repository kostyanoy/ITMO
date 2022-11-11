package lab4.myQuest.locations

import lab4.functionality.ActionFactory
import lab4.functionality.Location
import lab4.functionality.Player
import lab4.myQuest.items.BookShell
import lab4.myQuest.items.BreakableItem

class Corner : Location("Угол комнаты", { "Угол непонятной комнаты, которым заканчивается длинная стена." }) {
    init {
        items.add(BreakableItem("Люстра") { "Хрустальная люстра" })
        items.add(BreakableItem("Лампа") { "Яркая лампа" })
        items.add(BookShell())

    }

    override fun enter(player: Player): String {
        player.actions.add(
            ActionFactory().changeLocation(
                "Отшвырнуть стул",
                { "Увидев, что от стула никакой пользы нет, ${it.name} отшвырнул его от себя. В результате стул полетел вниз и, ударившись о пол, подскочил кверху, словно резиновый, сам же ${it.name} отлетел к потолку и, отскочив от него, полетел вниз. По пути он столкнулся с летящим навстречу стулом и получил удар спинкой стула прямо по переносице. Удар был настолько силен, что Знайка ошалел от боли и на некоторое время перестал трепыхаться в воздухе. " },
                Unconscious(), true
            )
        )
        return ""
    }

}