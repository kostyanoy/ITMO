package lab4.myQuest

import lab4.functionality.Designer
import lab4.functionality.Player
import lab4.functionality.Quest
import lab4.myQuest.locations.Floor
import lab4.myquest.locations.Ceil

class MyQuest(designer: Designer, player: Player) : Quest(designer, player) {
    init {
        val floor = Floor()
        val ceil = Ceil()
        floor.locations.add(ceil)

        player.location.locations.add(floor)
    }

}