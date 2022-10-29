package lab3.myquest.locations;

import lab3.functionality.Location;
import lab3.functionality.Player;

public class Unconscious extends Location {
    public Unconscious(String name) {
        super(name, p -> p.getName() + " пытается заглянуть внутрь себя");
    }

    @Override
    public String enter(Player player) {
        return String.format("Удар был настолько силен, что %s ошалел от боли и на некоторое время перестал трепыхаться в воздухе.", player.getName());
    }
}
