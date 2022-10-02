package lab2.pokemons;

import lab2.moves.physical.AerialAce;
import lab2.moves.status.Agility;
import lab2.moves.physical.Facade;
import lab2.moves.physical.IceShard;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Articuno extends Pokemon {

    public Articuno(String name, int level) {
        super(name, level);
        setType(Type.ICE, Type.FLYING);
        setStats(90, 85, 100, 95, 125, 85);
        addMove(new AerialAce());
        addMove(new IceShard());
        addMove(new Facade());
        addMove(new Agility());
    }
}
