package lab4.di

import lab4.functionality.Quest
import lab4.myQuest.MyQuest
import org.koin.dsl.module

val questModule = module {
    factory<Quest> {
        MyQuest(designer = get(), player = get())
    }
}