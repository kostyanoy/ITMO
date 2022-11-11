package lab4.myQuest.locations

import lab4.functionality.Location
import lab4.functionality.Player
import lab4.myQuest.items.Window


class Start : Location("Комната", { "Достаточно просторная комната" }) {
    init {
        items.add(Window())
    }

    override fun enter(player: Player): String {
        return ""
    }
}