package Creatures;

import Enums.FaceColor;
import Enums.HeadWear;
import Enums.MoveType;
import Environment.Window;
import Exceptions.IllegalWindowMove;
import Interfaces.Comeable;
import Interfaces.Flyable;

import java.util.Objects;

public class MysteryCreature extends Creature implements Flyable {
    private FaceColor faceColor;
    private HeadWear headWear;
    private boolean lookLikeCarlson;

    public MysteryCreature() {
        this(FaceColor.DEFAULT, HeadWear.NOTHING, true);
    }

    public MysteryCreature(FaceColor faceColor, HeadWear headWear, boolean lookLikeCarlson) {
        this.faceColor = faceColor;
        this.headWear = headWear;
        this.lookLikeCarlson = lookLikeCarlson;
        System.out.println("Мистическое существо создано");
    }

    public void prepareToFly() {
        System.out.println(this + " готовилось к отлету");
    }

    public void flyAway() {
        System.out.println(this + " улетело");
    }

    @Override
    public void move(MoveType parameters, Comeable direction) {
        System.out.println(this + " крипово " + parameters + " к " + direction);
    }

    public boolean isLikeCarlson() {
        return this.lookLikeCarlson;
    }

    public FaceColor getFaceColor() {
        return this.faceColor;
    }

    public void setFaceColor(FaceColor color) {
        this.faceColor = color;
    }

    public HeadWear getHeadWear() {
        return this.headWear;
    }

    public void setHeadWear(HeadWear clothItem) {
        this.headWear = clothItem;
    }

    public void openWindow(Window window) {
        try {
            window.openWindow();
            System.out.println(this + " открыло окно");
        } catch (IllegalWindowMove e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeWindow(Window window) {
        try {
            window.closeWindow();
            System.out.println(this + " закрыло окно");
        } catch (IllegalWindowMove e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Мистическое существо с " + this.getFaceColor() + " лицом и " + this.getHeadWear() + " на голове";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MysteryCreature creature = (MysteryCreature) obj;
        return (Objects.equals(this.faceColor, creature.faceColor)) && (Objects.equals(this.headWear, creature.headWear)) && (Objects.equals(this.lookLikeCarlson, creature.lookLikeCarlson));
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceColor, headWear, lookLikeCarlson);
    }
}
