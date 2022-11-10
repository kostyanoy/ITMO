package lab4.interation

import lab4.functionality.Writer

class ConsoleWriter : Writer {
    override fun write(text: String) {
        print(text)
    }

    override fun writeln(text: String) {
        println(text)
    }
}