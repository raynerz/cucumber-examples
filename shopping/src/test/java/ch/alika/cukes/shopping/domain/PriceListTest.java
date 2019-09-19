package ch.alika.cukes.shopping.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceListTest {

    private static final String BANANA = "banana";
    private static final String ORANGE = "orange";
    private static final Money BANANA_PRICE = new Money(1, 25);
    private static final Money ORANGE_PRICE = new Money(1, 45);
    private PriceList priceList;

    @BeforeEach
    void setup() {
        this.priceList = new PriceList();
        priceList.putPrice(BANANA, BANANA_PRICE);
        priceList.putPrice(ORANGE, ORANGE_PRICE);
    }

    @Test
    void wherePricesAreRetrieved() {
        assertThat(priceList.getPrice(BANANA),is(BANANA_PRICE));
        assertThat(priceList.getPrice(ORANGE),is(ORANGE_PRICE));
    }

    @Test
    void wherePriceDoesNotExist() {
        assertThrows(PriceNotFoundException.class, () -> priceList.getPrice("Nonexistent_product"));
    }
}