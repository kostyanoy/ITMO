package lab2.moves.status;

import ru.ifmo.se.pokemon.*;

public class Hypnosis extends StatusMove {
    public Hypnosis() {
        super(Type.PSYCHIC, 0, 60);
    }

    @Override
    protected String describe() {
        return "использует гипнотическое внушения, чтобы погрузить врага в сон";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        var e = (new Effect()).condition(Status.SLEEP).attack(0).turns((int) (Math.random() * 3 + 1));
        pokemon.addEffect(e);
    }
}
