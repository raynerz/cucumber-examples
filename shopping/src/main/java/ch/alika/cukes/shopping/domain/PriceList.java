package ch.alika.cukes.shopping.domain;

public class PriceList {
    private Money price = new Money();

    public void putPrice(Money price) {
        this.price = price;
    }

    Money getPrice() {
        return price;
    }
}
