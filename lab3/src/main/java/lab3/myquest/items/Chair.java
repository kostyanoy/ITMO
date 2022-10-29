package lab3.myquest.items;

import lab3.functionality.Action;
import lab3.functionality.Item;
import lab3.myquest.locations.Corner;
import lab3.myquest.locations.Rocket;
import lab3.myquest.locations.Unconscious;

public class Chair extends Item {
    public Chair(String name) {
        super(name, p -> "Деревянный стул. Удобный, чтобы сидеть, если бы это было возможно сейчас.", true);
        addAction(new Action("Схватить стул", p -> p.getName() + " хватает стул за ножку, но это не помогает удержаться на месте.", (q, p) -> {
            p.clearActions();
            p.addAction(new Action("Подняться", pl -> pl.getName() + " снова оказывается в воздухе.", (qu, pl) -> q.enterLocation(new Corner("Угол комнаты")), true));
            p.addAction(new Action("Отпустить стул", pl -> pl.getName() + " пытается поставить стул, но он остаётся висеть в воздухе", (qu, pl) -> {
                qu.curLocation.addItem(new Chair("Стул"));
                pl.clearActions();
            }));
            clearActions();
        }, true));
        addAction(new Action("Отшвырнуть", p -> String.format("Увидев, что от стула никакой пользы нет, %s отшвырнул его от себя. В результате стул полетел вниз и, ударившись о пол, подскочил кверху, словно резиновый, сам же %s отлетел к потолку и, отскочив от него, полетел вниз. По пути он столкнулся с летящим навстречу стулом и получил удар спинкой стула прямо по переносице.", p.getName(), p.getName()), (q, p) -> {
            p.damage();
            p.addAction(new Action("Прийти в себя", pl -> String.format("Придя постепенно в себя, %s убедился, что висит в какой-то нелепой позе посреди комнаты, между полом и потолком.", pl.getName()), (qu, pl) -> qu.enterLocation(new Rocket("Космический корабль")), true));
            q.enterLocation(new Unconscious("Пустота?"));
        }));
    }
}
