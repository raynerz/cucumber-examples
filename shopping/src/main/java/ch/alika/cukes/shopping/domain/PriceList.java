package ch.alika.cukes.shopping.domain;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private final Map<String,Money> prices = new HashMap<>();

    public void putPrice(String productName, Money productPrice) {
        prices.put(productName,productPrice);
    }

    Money getPrice(String productName) {
        Money result = prices.get(productName);
        if (result == null)
            throw new PriceNotFoundException(productName);

        return result;
    }
}
