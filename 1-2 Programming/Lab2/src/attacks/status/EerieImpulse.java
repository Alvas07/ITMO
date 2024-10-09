package attacks.status;

import ru.ifmo.se.pokemon.*;

public class EerieImpulse extends StatusMove {

    public EerieImpulse() {
        super(Type.ELECTRIC, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Eerie Impulse";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPECIAL_ATTACK, -2));
    }

}
