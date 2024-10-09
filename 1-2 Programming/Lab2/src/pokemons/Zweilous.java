package pokemons;

import attacks.physical.DoubleHit;
import ru.ifmo.se.pokemon.*;

public class Zweilous extends Deino {

    public Zweilous() {
        this("NoName", 1);
    }

    public Zweilous(String name, int level) {
        super(name, level);
        this.setType(Type.DARK, Type.DRAGON);
        this.setStats(72,85, 70, 65, 70, 58);
        this.addMove(new DoubleHit());
    }

}
