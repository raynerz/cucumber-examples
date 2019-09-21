package ch.alika.cukes.shopping.domain;

public class ShoppingCart implements IShoppingCart {
    private final IPricingFunction pricingFunction;
    private Money totalPrice = new Money();

    public ShoppingCart(IPricingFunction pricingFunction) {
        this.pricingFunction = pricingFunction;
    }

    @Override
    public Money getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void add(String productName, Integer quantity) {
        this.totalPrice = totalPrice.plus(pricingFunction.apply(productName).multipliedBy(quantity));
    }
}
