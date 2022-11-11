package lab4.myQuest

import lab4.functionality.Designer
import lab4.functionality.Player
import lab4.functionality.Quest
import lab4.myQuest.locations.Floor
import lab4.myQuest.locations.Space
import lab4.myquest.locations.Ceil

class MyQuest(designer: Designer, player: Player) : Quest(designer, player) {
    init {
        player.location = Space()
        player.location
            .addOneWayLocation(Floor())
            .addOneWayLocation(Ceil())
    }

}