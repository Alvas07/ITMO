package Environment;

import Creatures.Creature;
import Interfaces.Itemable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LivingRoom extends Room {
    public LivingRoom() {
        this("Гостиная", new ArrayList<Creature>(), new ArrayList<Itemable>());
    }

    public LivingRoom(String name, List<Creature> creaturesInside, List<Itemable> itemsInside) {
        this.name = name;
        this.creaturesInside = creaturesInside;
        this.itemsInside = itemsInside;
        System.out.println("Гостиная " + this.name + " создана");
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LivingRoom livingRoom = (LivingRoom) obj;
        return (Objects.equals(this.name, livingRoom.name)) && (Objects.equals(this.creaturesInside, livingRoom.creaturesInside)) && (Objects.equals(this.itemsInside, livingRoom.itemsInside));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creaturesInside, itemsInside);
    }
}
