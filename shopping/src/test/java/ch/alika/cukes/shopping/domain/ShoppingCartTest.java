package ch.alika.cukes.shopping.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ch.alika.cukes.shopping.domain.Money.$0_00;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ShoppingCartTest {

    private static final Money BANANA_PRICE = new Money(1, 20);
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
    void whereCartContainsOneItem() {
        cart.add(BANANA, 2);
        assertThat(cart.getTotalPrice(),is(BANANA_PRICE.multipliedBy(2)));
    }


    private Money getPrice(String productName) {
        if (BANANA.equals(productName))
            return BANANA_PRICE;

        throw new PriceUnknownException(productName);
    }
}