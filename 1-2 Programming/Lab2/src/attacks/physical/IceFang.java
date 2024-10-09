package attacks.physical;

import ru.ifmo.se.pokemon.*;

public class IceFang extends PhysicalMove {

    public IceFang() {
        super(Type.ICE, 65, 95);
    }

    @Override
    protected String describe() {
        return "использует Ice Fang";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (0.1 > Math.random()) {
            Effect.flinch(p);
        }

        if (0.1 > Math.random()) {
            Effect.freeze(p);
        }
    }

}
