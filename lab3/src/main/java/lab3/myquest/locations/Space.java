package lab3.myquest.locations;

import lab3.functionality.Action;
import lab3.functionality.Item;
import lab3.functionality.Location;
import lab3.functionality.Player;

public class Space extends Location {
    public Space(String name) {
        super(name, p -> p.getName() + " понимает, что парит над полом!");
        var shell = new Item("Шкаф", "Шкаф для книг с открытой дверцей. Что он здесь делает?");
        shell.addAction(new Action("Закрыть дверцу", p -> p.getName() + " закрыл дверцу шкафа", (q, p) -> shell.setDescription("Шкаф для книг с закрытой дверцей."), true));
        addAction(new Action("Прислушаться к ощущениям", p -> String.format("Вместе с головокружением у %s появилось какое-то странное ощущение зависания вниз головой, то есть ему на какой-то миг показалось, будто он перевернут кверху ногами", p.getName()), (q, p) -> {
                    System.out.println(p.getName() + " убедился, что он вовсе не вверх ногами.");
                    addItem(shell);
                }, true)
        );
    }

    @Override
    public String enter(Player player) {
        return "";
    }
}
