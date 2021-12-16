package flyweight;

import java.util.HashMap;

public class BigCharFactory {
    private static BigCharFactory singleton = new BigCharFactory();

    private HashMap<Character, BigChar> pool = new HashMap<>();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char charName) {
        BigChar bc = null;
        if (pool.containsKey(charName)) {
            bc = pool.get(charName);
        }
        if (bc == null) {
            bc = new BigChar(charName);
            pool.put(charName, bc);
        }
        return bc;
    }
}
