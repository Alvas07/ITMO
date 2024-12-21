package Creatures;

import Enums.MoveType;
import Interfaces.Comeable;
import Interfaces.Flyable;

public class Carlson extends Creature implements Flyable {
    public Carlson() {
        System.out.println("Карлсон создан");
    }

    @Override
    public void move(MoveType parameters, Comeable direction) {
        System.out.println(this + ", поглаживая живот, " + parameters + " к " + direction);
    }

    public void prepareToFly() {
        System.out.println(this + " готовился к отлету");
    }

    public void flyAway() {
        System.out.println(this + " улетел");
    }

    @Override
    public String toString() {
        return "Карлсон";
    }
}
