package lab2.pokemons;

import lab2.moves.physical.StoneEdge;

public class Granbull extends Snubbull{
    public Granbull(String name, int level) {
        super(name, level);
        setStats(90, 120, 75, 60, 60, 45);
        addMove(new StoneEdge());
    }
}
