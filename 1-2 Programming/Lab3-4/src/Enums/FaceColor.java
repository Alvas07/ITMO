package Enums;

import java.util.Random;

public enum FaceColor {
    DEFAULT("чистое"),
    BLACK("измазано чёрным"),
    RED("в крови"),
    GREEN("измазано зелёным"),
    WHITE("измазано белым");
    private String color;

    public static FaceColor getRandomFaceColor() {
        FaceColor[] values = FaceColor.values();
        return values[new Random().nextInt(values.length)];
    }

    FaceColor() {
        this("измазано чёрным");
    }

    FaceColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
