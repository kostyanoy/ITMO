package lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class IceShard extends PhysicalMove {
    public IceShard() {
        super(Type.ICE, 40, 100, 1, 1);
    }

    @Override
    protected String describe() {
        return "со вспышкой замораживает куски льда и бросает их";
    }
}
