package lab4.myQuest.locations

import lab4.functionality.ActionFactory
import lab4.functionality.Location
import lab4.functionality.Player

class Unconscious : Location("Пустота?", { "${it.name} пытается заглянуть внутрь себя." }) {
    override fun enter(player: Player): String {
        player.damage()
        player.actions.add(
            ActionFactory().changeLocation(
                "Прийти в себя",
                { "Придя постепенно в себя, ${it.name} убедился, что висит в какой-то нелепой позе посреди комнаты, между полом и потолком." },
                Rocket(),
                true
            )
        )
        return ""
    }

}