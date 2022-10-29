package lab3.myquest.items;

import lab3.functionality.Action;
import lab3.functionality.Item;

public class BreakableItem extends Item {

    public BreakableItem(String name, String description) {
        super(name, description);
        addAction(new Action("Разбить", p -> p.getName() + " задевает что-то своим телом. Бедная " + name, (q, p) -> {
            setName("Осколки");
            setDescription("Разбитые остатки какого-то предмета");
        }, true));
    }
}
