package attacks.status;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {

    public Rest() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Rest";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect.sleep(p);
        p.setStats(67, p.getStat(Stat.ATTACK), p.getStat(Stat.DEFENSE), p.getStat(Stat.SPECIAL_ATTACK), p.getStat(Stat.SPECIAL_DEFENSE), p.getStat(Stat.SPEED));
    }

}
