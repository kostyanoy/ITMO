package lab3.functionality;

import java.util.Objects;

public abstract class Nameable {

    private String name;
    private Description description;

    public Nameable(String name, Description description) {
        this.name = name;
        this.description = description;
    }

    public Nameable(String name, String description) {
        this(name, p -> description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(Player player) {
        return description.getDescription(player);
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setDescription(String description) {
        setDescription(p -> description);
    }
}
