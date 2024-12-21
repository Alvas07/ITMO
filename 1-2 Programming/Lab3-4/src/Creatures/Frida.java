package Creatures;

import Environment.Telephone;
import Exceptions.IllegalHandsetMove;

import java.util.Objects;

public class Frida extends Human {
    public Frida() {
        this("Фрида");
    }

    public Frida(String name) {
        this.name = name;
        System.out.println("Фрида " + this.name + " создана");
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

    public void want(String action) {
        System.out.println(this + " хотела " + action);
    }

    public void ask(Human person) {
        System.out.println(this + " засыпала " + person + " вопросами");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Frida frida = (Frida) obj;
        return Objects.equals(this.name, frida.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
