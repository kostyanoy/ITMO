package lab4.myQuest.locations

import lab4.functionality.Action
import lab4.functionality.Location
import lab4.functionality.Player
import lab4.myQuest.items.Shell

class Space : Location("Пространство", { it.name + " понимает, что парит над полом!" }) {
    init {
        actions.add(
            Action(
                "Прислушаться к ощущениям",
                { "Вместе с головокружением у ${it.name} появилось какое-то странное ощущение зависания вниз головой, то есть ему на какой-то миг показалось, будто он перевернут кверху ногами\n${it.name} убедился, что он вовсе не вверх ногами." },
                { _, _ -> items.add(Shell()) },
                true
            )
        )
    }

    override fun enter(player: Player): String {
        return ""
    }
}