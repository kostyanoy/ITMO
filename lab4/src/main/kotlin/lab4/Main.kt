package lab4

import lab4.di.interactionModule
import lab4.di.playerModule
import lab4.di.questModule
import lab4.functionality.Quest
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

interface Welcome{
    fun welcome()
}

fun main(args: Array<String>) {
    startKoin {
        modules(listOf(interactionModule, playerModule, questModule))
    }
    val w = object : Welcome {
        override fun welcome() {
            println("Welcome!")
        }
    }
    w.welcome()
    Application().QuestManager().start()
    Application.GoodbyeManager().goodbye()
}

class Application : KoinComponent {
    private val quest: Quest by inject()

    inner class QuestManager {
        fun start() {
            quest.start()
        }
    }

    class GoodbyeManager {
        fun goodbye(){
            println("goodbye, my friend")
        }
    }
}
