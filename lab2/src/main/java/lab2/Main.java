package lab2;

import lab2.pokemons.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Program started");

        Battle b = new Battle();
        var t1p1 = new Articuno("Птичка", 5);
        var t1p2 = new Snubbull("Псина", 5);
        var t1p3 = new Granbull("Рекс", 5);

        var t2p1 = new Poliwag("Пузырь", 5);
        var t2p2 = new Poliwhirl("Рыб", 5);
        var t2p3 = new Politoed("Лягуха", 5);

        b.addAlly(t1p1);
        b.addAlly(t1p2);
        b.addAlly(t1p3);

        b.addFoe(t2p1);
        b.addFoe(t2p2);
        b.addFoe(t2p3);
        b.go();

        log.info("Program finished");
    }
}
