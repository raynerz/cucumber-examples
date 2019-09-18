package ch.alika.cukes.shopping.domain;

public class ShoppingCart {
    private final PriceList priceList;
    private Money totalPrice = new Money();

    public ShoppingCart(PriceList priceList) {
        this.priceList = priceList;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public void add(String itemName, Integer quantity) {
        this.totalPrice = totalPrice.plus(priceList.getPrice(itemName).multipliedBy(quantity));
    }
}
