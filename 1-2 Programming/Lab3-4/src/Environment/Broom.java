package Environment;

import Exceptions.IllegalBroomMove;
import Interfaces.Comeable;
import Interfaces.Flyable;
import Interfaces.Itemable;

import java.util.Objects;

public class Broom implements Itemable, Comeable {
    private Flyable passenger;

    public Broom() {
        this(null);
    }

    public Broom(Flyable passenger) {
        this.passenger = passenger;
        System.out.println("Метла создана");
    }

    public void addPassenger(Flyable passenger) throws IllegalBroomMove {
        if (this.passenger == null) {
            this.passenger = passenger;
            System.out.println(passenger + " сел на метлу");
        } else throw new IllegalBroomMove("На метле уже кто-то есть");
    }

    public void removePassenger() throws IllegalBroomMove {
        if (this.passenger != null) {
            System.out.println(this.passenger + " cлез с метлы");
            this.passenger = null;
        } else throw new IllegalBroomMove("На метле никого нет");
    }

    public Flyable getPassenger() {
        return this.passenger;
    }

    @Override
    public String toString() {
        return "Метла";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Broom broom = (Broom) obj;
        return Objects.equals(this.passenger, broom.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger);
    }

}
