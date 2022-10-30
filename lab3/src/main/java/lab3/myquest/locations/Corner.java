package lab3.myquest.locations;

import lab3.functionality.Action;
import lab3.functionality.Item;
import lab3.functionality.Location;
import lab3.functionality.Player;
import lab3.myquest.items.BreakableItem;

public class Corner extends Location {
    public Corner(String name) {
        super(name, "Угол непонятной комнаты, которым заканчивается длинная стена.");
        addItem(new BreakableItem("Люстра", "Красивая хрустальная люстра"));
        addItem(new BreakableItem("Лампа", "Яркая лампа"));
        var bookShell = new Item("Книжная полка", "Полка с множеством книг.");
        bookShell.addAction(new Action("Осмотреть", p -> p.getName() + " врезался головой в книжную полку, отчего книги разлетелись в разные стороны.", p -> bookShell.setDescription("Теперь уже пустая полка"), true));
        addItem(bookShell);
    }

    @Override
    public String enter(Player player) {
        player.damage();
        return player.getName() + " ударился спиной об стену, отскочил от нее, словно мячик, и полетел к противоположной стене";
    }
}
