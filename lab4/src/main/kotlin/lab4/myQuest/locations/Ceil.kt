package lab4.myquest.locations

import lab4.functionality.Location
import lab4.functionality.Player

class Ceil() : Location("Потолок", { it.name + " стал недолюбливать этот потолок." }) {
    override fun enter(player: Player): String {
        player.damage()
        return player.name + " ударился головой об потолок."
    }
}