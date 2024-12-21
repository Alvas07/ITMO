package Environment;

import Creatures.Creature;
import Exceptions.IllegalWindowMove;
import Interfaces.Comeable;
import Interfaces.Itemable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Window implements Comeable {
    private boolean isOpen;

    public Window() {
        this(true);
    }

    public Window(boolean isOpen) {
        this.isOpen = isOpen;
        System.out.println("Окно создано");
    }

    public boolean isWindowOpen() {
        return this.isOpen;
    }

    public void openWindow() throws IllegalWindowMove {
        if (!this.isWindowOpen()) {
            this.isOpen = true;
            System.out.println("Окно открыто");
        } else throw new IllegalWindowMove("Окно уже открыто");
    }

    public void closeWindow() throws IllegalWindowMove {
        if (this.isWindowOpen()) {
            this.isOpen = false;
            System.out.println("Окно закрыто");
        } else throw new IllegalWindowMove("Окно уже закрыто");
    }

    @Override
    public String toString() {
        return "Окно";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Window window = (Window) obj;
        return Objects.equals(this.isOpen, window.isOpen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpen);
    }

    public class Windowswill {
        private List<Itemable> itemsOnWindow;
        private List<Creature> creaturesOnWindow;

        public Windowswill() {
            this(new ArrayList<Itemable>(), new ArrayList<Creature>());
        }

        public Windowswill(List<Itemable> itemsOnWindow, List<Creature> creaturesOnWindow) {
            this.itemsOnWindow = itemsOnWindow;
            this.creaturesOnWindow = creaturesOnWindow;
            System.out.println("Подоконник создан");
        }

        public void setItems(Itemable ... items) {
            this.itemsOnWindow.clear();
            for (Itemable itemable : items) {
                this.addItem(itemable);
            }
        }

        public void addItem(Itemable item) {
            if (!this.itemsOnWindow.contains(item)) {
                this.itemsOnWindow.add(item);
                System.out.println(item + " появился на подоконнике");
            }
        }

        public List<Itemable> getItems() {
            return this.itemsOnWindow;
        }

        public void removeItem(Itemable item) {
            boolean check = this.itemsOnWindow.remove(item);
            if (check) {
                System.out.println(item + " пропал с подоконника");
            }
        }

        public void setCreatures(Creature ... creatures) {
            this.creaturesOnWindow.clear();
            for (Creature creature : creatures) {
                this.addCreature(creature);
            }
        }

        public void addCreature(Creature creature) {
            if (!this.creaturesOnWindow.contains(creature)) {
                this.creaturesOnWindow.add(creature);
                System.out.println(creature + " залез на подоконник");
            }
        }

        public List<Creature> getCreatures() {
            return this.creaturesOnWindow;
        }

        public void removeCreature(Creature creature) {
            boolean check = this.creaturesOnWindow.remove(creature);
            if (check) {
                System.out.println(creature + " слез с подоконника");
            }
        }

        @Override
        public String toString() {
            return "Подоконник";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Windowswill windowswill = (Windowswill) obj;
            return Objects.equals(this.itemsOnWindow, windowswill.itemsOnWindow);
        }

        @Override
        public int hashCode() {
            return Objects.hash(itemsOnWindow);
        }
    }
}

