package lab4.functionality

abstract class Quest(private val designer: Designer, protected val player: Player) {

    fun start() {
        while (!player.completedQuest) {
            designer.interactionSession()
            checkPlayer()
        }
    }

    fun end(reason: String) {
        designer.endMessage(reason)
        player.completedQuest = true
    }

    private fun checkPlayer() {
        if (player.health === Health.DEAD) {
            end("$player.name умер!")
        } else if (player.completedQuest) {
            end("Поздравляем с завершением квеста")
        }
    }
}