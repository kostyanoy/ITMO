package lab4.di

import lab4.functionality.Designer
import lab4.functionality.Reader
import lab4.functionality.Writer
import lab4.interation.ConsoleReader
import lab4.interation.ConsoleWriter
import lab4.interation.SimpleDesigner
import org.koin.dsl.module

val interactionModule = module {
    single<Reader> {
        ConsoleReader()
    }
    single<Writer> {
        ConsoleWriter()
    }
    factory<Designer>{
        SimpleDesigner(reader = get(), writer = get(), player = get())
    }
}