package lab2.pokemons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ifmo.se.pokemon.Pokemon;

public class BasePokemon extends Pokemon {
    private static Logger log = LoggerFactory.getLogger(BasePokemon.class);

    public BasePokemon(String name, int level) {
        super(name, level);
        log = LoggerFactory.getLogger(this.getClass());
        log.debug("{} created with name {}", this.getClass().getName(), name);
    }
}
