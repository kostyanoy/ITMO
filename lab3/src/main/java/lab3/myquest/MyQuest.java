package lab3.myquest;

import lab3.functionality.Action;
import lab3.interaction.ConsoleDesigner;
import lab3.functionality.Player;
import lab3.interaction.ConsoleReader;
import lab3.interaction.ConsoleWriter;
import lab3.functionality.Quest;
import lab3.myquest.items.Chair;
import lab3.myquest.locations.Ceil;
import lab3.myquest.locations.Floor;

public class MyQuest extends Quest {
    public MyQuest(Player player) {
        super(new ConsoleDesigner(new ConsoleReader(), new ConsoleWriter(), player), player);
        var ceil = new Ceil("Потолок");
        player.getLocation().addAction(new Action("Выпрямиться", p -> p.getName() + " хотел выпрямиться, но как раз в это время его снизу словно толкнуло что-то и подбросило под потолок.", p -> p.setLocation(ceil)));
        var floor = new Floor("Пол");
        floor.addItem(new Chair("Стул"));
        ceil.addLocation(floor);
    }
}
