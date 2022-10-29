package lab3.myquest.locations;

import lab3.functionality.Location;
import lab3.functionality.Player;

public class Ceil extends Location {
    public Ceil(String name) {
        super(name, p -> p.getName() + " стал недолюбливать этот потолок.");
    }

    @Override
    public String enter(Player player) {
        player.damage();
        return player.getName() + " ударился головой об потолок.";
    }
}
