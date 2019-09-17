package ch.alika.cukes.shopping.support;

import ch.alika.cukes.shopping.domain.PriceList;
import ch.alika.cukes.shopping.domain.ShoppingCart;
import lombok.Value;

@Value
public class ShoppingHelper {
    private final PriceList priceList = new PriceList();
    private final ShoppingCart cart = new ShoppingCart(priceList);

}
