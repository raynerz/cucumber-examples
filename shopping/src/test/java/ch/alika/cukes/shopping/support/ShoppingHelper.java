package ch.alika.cukes.shopping.support;

import ch.alika.cukes.shopping.domain.IPriceList;
import ch.alika.cukes.shopping.domain.IShoppingCart;
import ch.alika.cukes.shopping.domain.PriceList;
import ch.alika.cukes.shopping.domain.ShoppingCart;

public class ShoppingHelper {
    private final IPriceList priceList;
    private final IShoppingCart cart;

    public ShoppingHelper() {
        priceList = new PriceList();
        cart = new ShoppingCart(priceList::getPrice);
    }

    public IPriceList getPriceList() {
        return priceList;
    }

    public IShoppingCart getCart() {
        return cart;
    }
}
