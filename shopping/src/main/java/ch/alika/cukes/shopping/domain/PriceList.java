package ch.alika.cukes.shopping.domain;

import java.util.HashMap;
import java.util.Map;

public class PriceList implements IPriceList {
    private final Map<String,Money> prices = new HashMap<>();

    @Override
    public void putPrice(String productName, Money productPrice) {
        prices.put(productName,productPrice);
    }

    @Override
    public Money getPrice(String productName) {
        Money result = prices.get(productName);
        if (result == null)
            throw new PriceUnknownException(productName);

        return result;
    }
}
