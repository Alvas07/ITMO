package Enums;

import java.util.Random;

public enum MoveType {
    DEFAULT("пошёл"),
    FAST("побежал"),
    SLOW("побрёл");
    private String description;

    public static MoveType getRandomMoveType() {
        MoveType[] values = MoveType.values();
        return values[new Random().nextInt(values.length)];
    }

    MoveType() {
        this("пошёл");
    }

    MoveType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
