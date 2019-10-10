package ch.alika.cukes.shopping.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ch.alika.cukes.shopping.domain.Money.$0_00;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingCartTest {

    private static final Money BANANA_PRICE = new Money(1, 20);
    private static final Money ORANGE_PRICE = new Money(1, 0);
    private static final String ORANGE = "orange";
    private static String BANANA = "banana";
    private IShoppingCart cart;

    @BeforeEach
    void setupShoppingCart() {
        cart = new ShoppingCart(this::getPrice);
    }

    @Test
    void whereCartIsEmpty() {
        assertThat(cart.getTotalPrice(),is($0_00));
    }

    @Test
    void whereProductWithoutPriceAddedToCart() {
        assertThrows(PriceUnknownException.class, () -> cart.add("ProductWithoutPrice", 1));
    }

    @Test
    void whereCartContainsOneProduct() {
        cart.add(BANANA, 2);
        assertThat(cart.getTotalPrice(),is(BANANA_PRICE.multipliedBy(2)));
    }

    @Test
    void whereCartContainsMultipleProducts() {
        cart.add(BANANA, 2);
        cart.add(ORANGE, 1);
        final Money expectTotalPrice = BANANA_PRICE.multipliedBy(2).plus(ORANGE_PRICE);
        assertThat(cart.getTotalPrice(),is(expectTotalPrice));
    }

    private Money getPrice(String productName) {
        if (BANANA.equals(productName))
            return BANANA_PRICE;

        if (ORANGE.equals(productName))
            return ORANGE_PRICE;

        throw new PriceUnknownException(productName);
    }
}