package attacks.physical;

import ru.ifmo.se.pokemon.*;

public class PlayRough extends PhysicalMove {

    public PlayRough() {
        super(Type.FAIRY, 90, 90);
    }

    @Override
    protected String describe() {
        return "использует Play Rough";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.1).turns(0).stat(Stat.ATTACK, -1));
    }

}
