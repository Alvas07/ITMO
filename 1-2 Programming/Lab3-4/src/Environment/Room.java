package Environment;

import Creatures.Creature;
import Interfaces.Comeable;
import Interfaces.Itemable;

import java.util.List;

public abstract class Room implements Comeable {
    protected String name;
    protected List<Creature> creaturesInside;
    protected List<Itemable> itemsInside;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatures(Creature ... creatures) {
        this.creaturesInside.clear();
        for (Creature creature : creatures) {
            this.addCreature(creature);
        }
    }

    public void addCreature(Creature creature) {
        if (!this.creaturesInside.contains(creature)) {
            this.creaturesInside.add(creature);
            System.out.println(creature + " зашёл в " + this.name);
        }
    }

    public void removeCreature(Creature creature) {
        boolean check = this.creaturesInside.remove(creature);
        if (check) {
            System.out.println(creature + " вышел из " + this.name);
        }
    }

    public List<Creature> getCreatures() {
        return this.creaturesInside;
    }

    public void setItems(Itemable ... items) {
        this.itemsInside.clear();
        for (Itemable itemable : items) {
            this.addItem(itemable);
        }
    }

    public void addItem(Itemable item) {
        if (!this.itemsInside.contains(item)) {
            this.itemsInside.add(item);
            System.out.println(item + " появился в " + this.name);
        }
    }

    public void removeItem(Itemable item) {
        boolean check = this.itemsInside.remove(item);
        if (check) {
            System.out.println(item + " пропал из " + this.name);
        }
    }

    public List<Itemable> getItems() {
        return this.itemsInside;
    }
}
