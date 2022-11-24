package lab4.functionality

enum class Health(val state: String) {
    HEALTHY("Полностью здоров"),
    SCRATCHED("Ушиблен"),
    INJURED("Ранен"),
    BLEEDING("Кровотечение"),
    DEATH_DOOR("При смерти"),
    DEAD("Мёртв");

    fun previous() = if (this == HEALTHY) HEALTHY else values()[ordinal - 1]

    fun next() = if (this == DEAD) DEAD else values()[ordinal + 1]
}