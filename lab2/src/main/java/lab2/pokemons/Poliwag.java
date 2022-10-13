package lab2.pokemons;

import lab2.moves.special.IceBeam;
import lab2.moves.status.Hypnosis;
import ru.ifmo.se.pokemon.Type;

public class Poliwag extends BasePokemon {
    public Poliwag(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(40, 50, 40, 40, 40, 90);
        addMove(new IceBeam());
        addMove(new Hypnosis());
    }
}
