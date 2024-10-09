package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.physical.PlayRough;
import attacks.special.ChargeBeam;
import attacks.status.Rest;
import attacks.status.EerieImpulse;


public class Dedenne extends Pokemon {

    public Dedenne() {
        this("NoName", 1);
    }

    public Dedenne(String name, int level) {
        super(name, level);
        this.setType(Type.ELECTRIC, Type.FAIRY);
        this.setStats(67, 58, 57, 81, 67, 101);
        this.setMove(new PlayRough(), new ChargeBeam(), new Rest(), new EerieImpulse());
    }

}
