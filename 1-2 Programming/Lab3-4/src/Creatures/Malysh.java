package Creatures;

import Environment.Telephone;
import Exceptions.IllegalHandsetMove;
import Interfaces.Comeable;

import java.util.Objects;

public class Malysh extends Human {
    public Malysh() {
        this("Малыш");
    }

    public Malysh(String name) {
        this.name = name;
        System.out.println("Малыш " + this.name + " создан");
    }

    @Override
    public void call(Human person, Telephone.Handset handset) {
        try {
            System.out.println(this + " поднял " + handset);
            handset.getUp();
            System.out.println(this + " позвонил " + person);
        } catch (IllegalHandsetMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void say(String text) {
        System.out.println(this + " сказал: '" + text + "'");
    }

    public void lookAt(Comeable obj) {
        System.out.println(this + " посмотрел на " + obj);
    }

    public void search(Comeable obj) {
        System.out.println(this + " искал " + obj);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Malysh malysh = (Malysh) obj;
        return Objects.equals(this.name, malysh.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
