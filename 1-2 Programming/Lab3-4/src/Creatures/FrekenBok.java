package Creatures;

import Enums.MoveType;
import Environment.Telephone;
import Exceptions.IllegalHandsetMove;
import Interfaces.Comeable;
import java.util.Objects;

public class FrekenBok extends Human {
    private final boolean isAbleToCome;

    public FrekenBok() {
        this("Фрекен Бок", false);
    }

    public FrekenBok(String name) {
        this(name, false);
    }

    public FrekenBok(String name, boolean isAbleToCome) {
        this.name = name;
        this.isAbleToCome = isAbleToCome;
        System.out.println("Фрекен Бок " + this.name + " создана");
    }

    public boolean isFree() {
        return this.isAbleToCome;
    }

    @Override
    public void call(Human person, Telephone.Handset handset) {
        try {
            System.out.println(this + " подняла " + handset);
            handset.getUp();
            System.out.println(this + " позвонила " + person);
        } catch (IllegalHandsetMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void say(String text) {
        System.out.println(this + " сказала: '" + text + "'");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FrekenBok frekenBok = (FrekenBok) obj;
        return (Objects.equals(this.name, frekenBok.name)) && (Objects.equals(this.isAbleToCome, frekenBok.isAbleToCome));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isAbleToCome);
    }
}
