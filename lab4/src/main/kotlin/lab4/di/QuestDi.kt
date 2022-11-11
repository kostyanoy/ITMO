package lab4.di

import lab4.functionality.Quest
import org.koin.dsl.module

val questModule = module {
    factory<Quest> {
        Quest(designer = get(), player = get())
    }
}