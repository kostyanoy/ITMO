package lab3.functionality;

public class Player extends Actionable {

    private Health health;
    private Location curLocation;
    private boolean completedQuest;

    public Player(String name, Location startLocation) {
        super(name, p -> String.format("Состояние %s\nЗдоровье: %s", p.getName(), p.getHealth().getName()));
        setHealth(Health.HEALTHY);
        setLocation(startLocation);
        setCompletedQuest(false);
    }

    public boolean isCompletedQuest() {
        return completedQuest;
    }

    public void setCompletedQuest(boolean completedQuest) {
        this.completedQuest = completedQuest;
    }

    public Location getLocation() {
        return curLocation;
    }

    public String setLocation(Location location) {
        this.curLocation = location;
        return location.enter(this);
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
