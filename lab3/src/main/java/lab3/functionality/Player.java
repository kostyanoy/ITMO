package lab3.functionality;

public class Player extends Actionable {

    private Health health;
    private Location curLocation;

    public Player(String name, Location startLocation) {
        super(name, p -> String.format("Состояние %s\nЗдоровье: %s", p.getName(), p.getHealth().getName()));
        setHealth(Health.HEALTHY);
        setLocation(startLocation);
    }

    public Location getLocation() {
        return curLocation;
    }

    public void setLocation(Location location) {
        this.curLocation = location;
        location.enter(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;

        return getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
