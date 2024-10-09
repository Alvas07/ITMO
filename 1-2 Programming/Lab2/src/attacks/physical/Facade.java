package attacks.physical;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {

    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected String describe() {
        return "использует Facade";
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        switch(def.getCondition()) {
            case BURN:
            case POISON:
            case PARALYZE:
                super.applyOppDamage(def, damage);
                super.applyOppDamage(def, damage);
                break;
            default:
                super.applyOppDamage(def, damage);
                break;
        }
    }

}
