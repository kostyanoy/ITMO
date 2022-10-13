package lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon pokemon, Pokemon pokemon1) {
        switch (pokemon.getCondition()) {
            case BURN, POISON, PARALYZE:
                power *= 2;
        }

        var damage = super.calcBaseDamage(pokemon, pokemon1);

        switch (pokemon.getCondition()) {
            case BURN, POISON, PARALYZE:
                power /= 2;
        }

        return damage;
    }

    @Override
    protected String describe() {
        return "заряжает атаку, которая усиливается, если покемон отравлен, подожжён или парализован";
    }
}
