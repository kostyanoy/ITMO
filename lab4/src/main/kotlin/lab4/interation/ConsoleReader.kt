package lab4.interation

import lab4.functionality.Reader

class ConsoleReader : Reader {
    override fun readLine() = readln()

    override fun readInt(): Int {
        while (true) {
            try {
                print("Введите число: ")
                val result: Int = readLine().toInt()
                println()
                return result
            } catch (e: Exception) {
                println("Необходимо ввести число!")
            }
        }
    }
}