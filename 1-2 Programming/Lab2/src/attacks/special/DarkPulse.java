package attacks.special;

import ru.ifmo.se.pokemon.*;

public class DarkPulse extends SpecialMove {

    public DarkPulse() {
        super(Type.DARK, 80, 100);
    }

    @Override
    protected String describe() {
        return "использует Dark Pulse";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (0.2 > Math.random()) {
            Effect.flinch(p);
        }
    }

}
