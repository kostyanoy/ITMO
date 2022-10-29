package lab3.functionality;

public enum Health {
    HEALTHY("Полностью здоров"),
    SCRATCHED("Ушиблен"),
    INJURED("Ранен"),
    BLEEDING("Кровотечение"),
    DEATH_DOOR("При смерти"),
    DEAD("Мёртв");

    private final String name;

    Health(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Health previous() {
        if (this == HEALTHY) return HEALTHY;
        return values()[this.ordinal() - 1];
    }

    public Health next() {
        if (this == DEAD) return DEAD;
        return values()[this.ordinal() + 1];
    }
}
