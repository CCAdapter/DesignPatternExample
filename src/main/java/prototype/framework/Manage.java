package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manage {
    private Map<String, Product> showCase = new HashMap<>();

    public void register(String name, Product product) {
        showCase.put(name, product);
    }

    public Product create(String protoName) {
        Product product = showCase.get(protoName);
        return product.createClone();
    }
}
