package lab3.myquest;

import lab3.functionality.Action;
import lab3.functionality.Quest;
import lab3.myquest.items.Chair;
import lab3.myquest.locations.Ceil;
import lab3.myquest.locations.Floor;
import lab3.myquest.locations.Space;

public class myQuest extends Quest {
    public myQuest() {
        super(new Space("Пространство"));
        var ceil = new Ceil("Потолок");
        startLocation.addAction(new Action("Выпрямиться", p -> p.getName() + " хотел выпрямиться, но как раз в это время его снизу словно толкнуло что-то и подбросило под потолок.", (q, p) -> q.enterLocation(ceil)));
        var floor = new Floor("Пол");
        floor.addItem(new Chair("Стул"));
        ceil.addLocation(floor);
    }
}
