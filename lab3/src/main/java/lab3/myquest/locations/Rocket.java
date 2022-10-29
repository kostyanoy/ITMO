package lab3.myquest.locations;

import lab3.functionality.Action;
import lab3.functionality.Location;
import lab3.functionality.Player;

public class Rocket extends Location {
    public Rocket(String name) {
        super(name, p -> p.getName() + " висит в какой-то нелепой позе посреди комнаты, между полом и потолком.");
        addAction(new Action("Осмотреться", p -> String.format("Неподалеку от него повис кверху ножками стул, люстра висела в каком-то противоестественном состоянии: не отвесно, как бывает всегда, а наискось, словно какая-то неведомая сила притягивала ее к стене; вокруг по всей комнате плавали книги. %s показалось странным, что и стул, и книги не падают на пол, а как бы взвешены в воздухе. Все это было похоже на состояние невесомости, которое %s наблюдал в кабине космического корабля во время путешествия на Луну.", p.getName(), p.getName()), (q, p) -> q.end("Поздравляем с завершением квеста!")));
    }

    @Override
    public String enter(Player player) {
        return "";
    }
}
