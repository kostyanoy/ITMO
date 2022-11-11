package lab4.di

import lab4.functionality.Player
import lab4.myQuest.locations.Space
import org.koin.dsl.module

val playerModule = module {
    single<Player> {
        Player("Незнайка", Space())
    }
}