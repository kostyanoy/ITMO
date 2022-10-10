package lab2.pokemons;

import lab2.moves.physical.Tackle;
import lab2.moves.status.TailWhip;
import lab2.moves.special.Thunderbolt;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Snubbull extends BasePokemon {
    public Snubbull(String name, int level) {
        super(name, level);
        setType(Type.FAIRY);
        setStats(60, 80, 50, 40, 40, 30);
        addMove(new TailWhip());
        addMove(new Tackle());
        addMove(new Thunderbolt());
    }
}
