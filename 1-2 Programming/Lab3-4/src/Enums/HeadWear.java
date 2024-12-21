package Enums;

import java.util.Random;

public enum HeadWear {
    NOTHING("ничего"),
    HEADSCARF("косынка"),
    HAT("шляпа"),
    CAP("кепка");
    private String clothItem;

    public static HeadWear getRandomHeadWear() {
        HeadWear[] values = HeadWear.values();
        return values[new Random().nextInt(values.length)];
    }

    HeadWear() {
        this("ничего");
    }

    HeadWear(String clothItem) {
        this.clothItem = clothItem;
    }

    @Override
    public String toString() {
        return this.clothItem;
    }
}
