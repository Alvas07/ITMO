package pokemons;

import attacks.status.Swagger;
import ru.ifmo.se.pokemon.*;

public class Hydreigon extends Zweilous {

    public Hydreigon() {
        this("NoName", 1);
    }

    public Hydreigon(String name, int level) {
        super(name, level);
        this.setType(Type.DARK, Type.DRAGON);
        this.setStats(92, 105, 90, 125, 90, 98);
        this.addMove(new Swagger());
    }

}
