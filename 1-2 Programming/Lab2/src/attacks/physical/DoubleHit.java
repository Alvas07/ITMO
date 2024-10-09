package attacks.physical;

import ru.ifmo.se.pokemon.*;

public class DoubleHit extends PhysicalMove {

    public DoubleHit() {
        super(Type.NORMAL, 35, 90);
    }

    @Override
    protected String describe() {
        return "использует Double Hit";
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
        super.applyOppDamage(def, damage);
    }

}

