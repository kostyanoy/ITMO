package lab2;

import lab2.pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon t1p1 = new Articuno("Птичка", 5);
        Pokemon t1p2 = new Snubbull("Псина", 5);
        Pokemon t1p3 = new Granbull("Рекс", 5);

        Pokemon t2p1  = new Poliwag("Пузырь", 5);
        Pokemon t2p2  = new Poliwhirl("Рыб", 5);
        Pokemon t2p3  = new Politoed("Лягуха", 5);

        b.addAlly(t1p1);
        b.addAlly(t1p2);
        b.addAlly(t1p3);

        b.addFoe(t2p1);
        b.addFoe(t2p2);
        b.addFoe(t2p3);
        b.go();
    }
}
