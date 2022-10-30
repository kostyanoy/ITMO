package lab3.functionality;

import java.util.ArrayList;

public abstract class Actionable extends Nameable {
    private final ArrayList<Action> actions;

    protected Actionable(String name, Description description) {
        super(name, description);
        actions = new ArrayList<>();
    }

    protected Actionable(String name, String description) {
        this(name, p -> description);
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(int ind) {
        actions.remove(ind);
    }

    public void clearActions() {
        actions.clear();
    }
}
