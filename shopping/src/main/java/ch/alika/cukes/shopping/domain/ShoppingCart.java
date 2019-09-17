package ch.alika.cukes.shopping.domain;

public class ShoppingCart {
    private final PriceList priceList;
    private int totalQuantity = 0;

    public ShoppingCart(PriceList priceList) {
        this.priceList = priceList;
    }

    public Money getTotalPrice() {
        return priceList.getPrice().multipliedBy(totalQuantity);
    }

    public void add(@SuppressWarnings("unused") String itemName, Integer quantity) {
        this.totalQuantity += quantity;
    }
}
