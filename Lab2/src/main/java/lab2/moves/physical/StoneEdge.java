package lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class StoneEdge extends PhysicalMove {
    public StoneEdge() {
        super(Type.ROCK, 100, 80);
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        if (Math.random() < 1.0 / 8) {
            return 2.0;
        }
        return 1.0;
    }

    @Override
    protected String describe() {
        return "пронзает противника острыми камнями снизу с повышенным шансом на крит";
    }
}
