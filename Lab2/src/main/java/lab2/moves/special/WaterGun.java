package lab2.moves.special;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class WaterGun extends SpecialMove {
    public WaterGun() {
        super(Type.WATER, 40, 100);
    }

    @Override
    protected String describe() {
        return "стреляет в противника мощным потоком воды";
    }
}
