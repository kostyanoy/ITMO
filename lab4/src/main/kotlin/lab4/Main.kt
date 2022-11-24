package lab4

import lab4.di.interactionModule
import lab4.di.playerModule
import lab4.di.questModule
import lab4.functionality.Quest
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface Welcome{
    fun welcome()
}

fun main(args: Array<String>) {
    // DI activation
    startKoin {
        modules(listOf(interactionModule, playerModule, questModule))
    }

    // some anon class
    val w = object : Welcome {
        override fun welcome() {
            println("Welcome!")
        }
    }
    w.welcome()
    // some inner class
    Application().QuestManager().start()
    // some sealed(?) class
    Application.GoodbyeManager().goodbye()
}

class Application : KoinComponent {
    private val quest by inject<Quest>()
    //inner class
    inner class QuestManager {
        fun start() {
            quest.start()
        }
    }
    // sealed(?) class
    class GoodbyeManager {
        fun goodbye(){
            println("goodbye, my friend")
        }
    }
}