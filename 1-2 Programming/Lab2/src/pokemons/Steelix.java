package pokemons;

import attacks.physical.IceFang;
import ru.ifmo.se.pokemon.*;

public class Steelix extends Onix {

    public Steelix() {
        this("NoName", 1);
    }

    public Steelix(String name, int level) {
        super(name, level);
        this.setType(Type.STEEL, Type.GROUND);
        this.setStats(75, 85, 200, 55, 65, 30);
        this.addMove(new IceFang());
    }

}
