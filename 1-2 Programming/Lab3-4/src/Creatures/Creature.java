package Creatures;

import Enums.MoveType;
import Interfaces.Comeable;
import Interfaces.Itemable;
import Interfaces.Moveable;

public abstract class Creature implements Moveable, Comeable, Itemable {
    public abstract void move(MoveType parameters, Comeable direction);
}
