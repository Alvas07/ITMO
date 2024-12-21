package Environment;

import Creatures.Creature;
import Interfaces.Itemable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kitchen extends Room {
    public Kitchen() {
        this("Кухня", new ArrayList<Creature>(), new ArrayList<Itemable>());
    }

    public Kitchen(String name, List<Creature> creaturesInside, List<Itemable> itemsInside) {
        this.name = name;
        this.creaturesInside = creaturesInside;
        this.itemsInside = itemsInside;
        System.out.println("Кухня " + this.name + " создана");
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Kitchen kitchen = (Kitchen) obj;
        return (Objects.equals(this.name, kitchen.name)) && (Objects.equals(this.creaturesInside, kitchen.creaturesInside)) && (Objects.equals(this.itemsInside, kitchen.itemsInside));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creaturesInside, itemsInside);
    }
}
