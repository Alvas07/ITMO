import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Dedenne p1 = new Dedenne("НедоПикачу", 1);
        Onix p2 = new Onix("Глыба", 1);
        Steelix p3 = new Steelix("Глыбище", 1);
        Deino p4 = new Deino("МиниДино", 1);
        Zweilous p5 = new Zweilous("НедоГидра", 1);
        Hydreigon p6 = new Hydreigon("Горыныч", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addAlly(p5);
        b.addFoe(p6);
        b.go();
    }

}