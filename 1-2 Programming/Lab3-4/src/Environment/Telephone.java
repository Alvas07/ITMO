package Environment;

import Exceptions.IllegalHandsetMove;
import Interfaces.Comeable;
import Interfaces.Itemable;

import java.util.List;
import java.util.Objects;

public record Telephone(String model, List<String> phoneNumbers) implements Itemable, Comeable {
    public static class Handset implements Itemable, Comeable {
        private boolean isUp;

        public Handset() {
            this(false);
        }

        public Handset(boolean isUp) {
            this.isUp = isUp;
            System.out.println("Телефон и трубка созданы");
        }

        public boolean isHandsetUp() {
            return this.isUp;
        }

        public void getUp() throws IllegalHandsetMove {
            if (!this.isHandsetUp()) {
                this.isUp = true;
                System.out.println("Трубка телефона поднята");
            } else throw new IllegalHandsetMove("Трубка телефона уже поднята");
        }

        public void getDown() throws IllegalHandsetMove {
            if (this.isHandsetUp()) {
                this.isUp = false;
                System.out.println("Трубка телефона положена");
            } else throw new IllegalHandsetMove("Трубка телефона уже положена");
        }

        @Override
        public String toString() {
            return "Трубка телефона";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Handset handset = (Handset) obj;
            return Objects.equals(this.isUp, handset.isUp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isUp);
        }
    }

    @Override
    public String toString() {
        return "Телефон";
    }
}
