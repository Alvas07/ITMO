package pokemons;

import attacks.physical.BrutalSwing;
import attacks.physical.Slam;
import attacks.status.Rest;
import ru.ifmo.se.pokemon.*;

public class Onix extends Pokemon {

    public Onix() {
        this("NoName", 1);
    }

    public Onix(String name, int level) {
        super(name, level);
        this.setType(Type.ROCK, Type.GROUND);
        this.setStats(35, 45, 160, 30, 45, 70);
        this.setMove(new BrutalSwing(), new Slam(), new Rest());
    }

}
