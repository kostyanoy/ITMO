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


    @Override
    public String toString() {
        return getName() + ": " + getDescription(new Player("player"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nameable nameable)) return false;

        if (getName() != null ? !getName().equals(nameable.getName()) : nameable.getName() != null) return false;
        return Objects.equals(description, nameable.description);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
