package lab3.functionality;

public enum Health {
    Healthy("Полностью здоров"), Scratched("Ушиблен"), Injured("Ранен"), Bleeding("Кровотечение"), DeathDoor("При смерти"), Dead("Мёртв");

    private final String name;

    Health(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Health previous() {
        if (this == Healthy) return Healthy;
        return values()[this.ordinal() - 1];
    }

    public Health next() {
        if (this == Dead) return Dead;
        return values()[this.ordinal() + 1];
    }
}
