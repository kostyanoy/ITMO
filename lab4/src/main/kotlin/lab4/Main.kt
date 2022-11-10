package lab4

import lab4.di.interactionModule
import lab4.di.playerModule
import lab4.di.questModule
import lab4.functionality.Quest
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    startKoin {
        modules(listOf(interactionModule, playerModule, questModule))
    }

    Application().start()
}

class Application : KoinComponent {
    private val quest: Quest by inject()

    fun start() {
        quest.start()
    }
}
