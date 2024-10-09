package attacks.special;

import ru.ifmo.se.pokemon.*;

public class ChargeBeam extends SpecialMove {

    public ChargeBeam() {
        super(Type.ELECTRIC, 50, 90);
    }

    @Override
    protected String describe() {
        return "использует Charge Beam";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.7).turns(0).stat(Stat.SPECIAL_ATTACK, 1));
    }

}
