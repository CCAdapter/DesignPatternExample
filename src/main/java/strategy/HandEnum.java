package strategy;

import java.util.HashMap;
import java.util.Map;

public enum HandEnum {
    HANDVALUE_GUU(0),
    HANDVALUE_CHO(1),
    HANDVALUE_PAA(2),
    ;

    private final int handValue;
    private static final String[] name = {"石头", "剪刀", "布"};
    private static final Map<Integer, HandEnum> hand = new HashMap<Integer, HandEnum>() {
        {
            put(0, HANDVALUE_GUU);
            put(1, HANDVALUE_CHO);
            put(2, HANDVALUE_PAA);
        }
    };

    private HandEnum(int handValue) {
        this.handValue = handValue;
    }

    public static HandEnum getHand(int handValue) {
        return hand.get(handValue);
    }

    public boolean isStrongerThan(HandEnum h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(HandEnum h) {
        return fight(h) == -1;
    }

    private int fight(HandEnum h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return name[handValue];
    }
}
