package lab3.myquest;

import lab3.functionality.Action;
import lab3.functionality.Player;
import lab3.interaction.CommandLineReader;
import lab3.interaction.CommandLineWriter;
import lab3.functionality.Quest;
import lab3.myquest.items.Chair;
import lab3.myquest.locations.Ceil;
import lab3.myquest.locations.Floor;

public class MyQuest extends Quest {
    public MyQuest(Player player) {
        super(new CommandLineReader(), new CommandLineWriter(), player);
        var ceil = new Ceil("Потолок");
        player.getLocation().addAction(new Action("Выпрямиться", p -> p.getName() + " хотел выпрямиться, но как раз в это время его снизу словно толкнуло что-то и подбросило под потолок.", (q, p) -> p.setLocation(ceil)));
        var floor = new Floor("Пол");
        floor.addItem(new Chair("Стул"));
        ceil.addLocation(floor);
    }
}
