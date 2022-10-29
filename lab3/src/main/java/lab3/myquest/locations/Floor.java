package lab3.myquest.locations;

import lab3.functionality.Location;
import lab3.functionality.Player;

public class Floor extends Location {
    public Floor(String name) {
        super(name, "Очень твердый пол");
    }

    @Override
    public String enter(Player player) {
        return player.getName() + " упал на пол, чувствуя, что его как бы подхватило ветром и куда-то несет.";
    }
}
