package lab2.pokemons;

import lab2.moves.physical.Waterfall;

public class Politoed extends Poliwhirl{
    public Politoed(String name, int level) {
        super(name, level);
        setStats(90, 75, 75, 90, 100, 70);
        addMove(new Waterfall());
    }
}
