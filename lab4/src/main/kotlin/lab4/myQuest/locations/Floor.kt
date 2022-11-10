package lab4.myQuest.locations

import lab4.functionality.Location
import lab4.functionality.Player

class Floor : Location("Пол", { it.name + "лежит на полу. Пол очень твёрдый" }) {
    override fun enter(player: Player): String {
        return "${player.name} упал на пол, чувствуя, что его как бы подхватило ветром и куда-то несет."
    }
}