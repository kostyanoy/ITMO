package lab4.functionality

enum class Health(val state: String) {
    HEALTHY("Полностью здоров"),
    SCRATCHED("Ушиблен"),
    INJURED("Ранен"),
    BLEEDING("Кровотечение"),
    DEATH_DOOR("При смерти"),
    DEAD("Мёртв");

    fun previous(): Health {
        return if (this == HEALTHY) HEALTHY else values()[ordinal - 1]
    }

    operator fun next(): Health {
        return if (this == DEAD) DEAD else values()[ordinal + 1]
    }
}