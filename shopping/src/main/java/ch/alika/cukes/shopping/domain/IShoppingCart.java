package ch.alika.cukes.shopping.domain;

public interface IShoppingCart {
    Money getTotalPrice();

    void add(String productName, Integer quantity);
}
