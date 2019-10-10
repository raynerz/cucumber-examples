package ch.alika.cukes.shopping.domain;

public interface IPriceList {
    void putPrice(String productName, Money productPrice);

    Money getPrice(String productName);
}
