package Creatures;

import Enums.MoveType;
import Environment.Telephone;
import Interfaces.Comeable;

public abstract class Human extends Creature {
    protected String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void move(MoveType parameters, Comeable direction) {
        System.out.println(this.name + " " + parameters + " к " + direction);
    }

    public abstract void say(String text);

    public abstract void call(Human person, Telephone.Handset handset);
}
