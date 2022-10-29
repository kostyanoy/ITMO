package lab3.functionality;

public class Player extends Actionable {

    private Health health;

    public Player(String name) {
        super(name, p -> String.format("Состояние %s\nЗдоровье: %s", p.getName(), p.getHealth().getName()));
        setHealth(Health.HEALTHY);
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void damage() {
        setHealth(getHealth().next());
    }

    public void regen() {
        setHealth(getHealth().previous());
    }
}
