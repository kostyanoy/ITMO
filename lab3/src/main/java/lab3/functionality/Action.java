package lab3.functionality;

public class Action extends Nameable {
    private final boolean disposable;
    private final Usable usable;

    public Action(String name, Description description, Usable usable) {
        this(name, description, usable, false);
    }

    public Action(String name, Description description, Usable usable, boolean disposable) {
        super(name, description);
        this.usable = usable;
        this.disposable = disposable;
    }

    public void use(Player player) {
        usable.use(player);
    }

    public boolean isDisposable() {
        return disposable;
    }
}
