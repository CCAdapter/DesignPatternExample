package flyweight.ex1ex2;

import java.util.HashMap;

public class BigCharFactory {
    private static BigCharFactory singleton = new BigCharFactory();

    private HashMap<Character, BigChar> pool = new HashMap<>();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char charName, boolean shared) {
        BigChar bc = null;
        if (shared) {
            bc = pool.getOrDefault(charName, new BigChar(charName));
        } else {
            bc = new BigChar(charName);
        }
        return bc;
    }
}
