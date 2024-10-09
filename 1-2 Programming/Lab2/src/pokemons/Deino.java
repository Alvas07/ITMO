package pokemons;

import attacks.physical.Facade;
import attacks.special.DarkPulse;
import ru.ifmo.se.pokemon.*;

public class Deino extends Pokemon {

    public Deino() {
        this("NoName", 1);
    }

    public Deino(String name, int level) {
        super(name, level);
        this.setType(Type.DARK, Type.DRAGON);
        this.setStats(52, 65, 50, 45, 50, 38);
        this.setMove(new DarkPulse(), new Facade());
    }

}
