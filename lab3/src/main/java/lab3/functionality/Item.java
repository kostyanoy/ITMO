package lab3.functionality;

public class Item extends Actionable {
    private final boolean consumable;

    public Item(String name) {
        this(name, p -> "", false);
    }

    public Item(String name, String description) {
        this(name, p -> description, false);
    }

    public Item(String name, Description description, boolean consumable) {
        super(name, description);
        this.consumable = consumable;
    }

    public boolean isConsumable() {
        return consumable;
    }
}
