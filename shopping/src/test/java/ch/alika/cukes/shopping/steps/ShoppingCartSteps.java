package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.IShoppingCart;
import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.domain.PriceUnknownException;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ShoppingCartSteps {

    final private ShoppingHelper helper;
    private boolean addItemToCartExpectedToFail = false;

    public ShoppingCartSteps(ShoppingHelper helper) {
        this.helper = helper;
    }

    @When("I add {int} {string}(s) to my cart")
    public void iAddItemToCart(Integer quantity, String itemName) {
        if (addItemToCartExpectedToFail)
            assertThrows( PriceUnknownException.class, () -> getCart().add(itemName, quantity));
        else
            getCart().add(itemName,quantity);
    }

    @Then("the total price should be {money}")
    public void theTotalPriceShouldBe(Money totalPrice) {
        assertThat(getCart().getTotalPrice(), is(totalPrice));
    }

    @Then("add item to my cart should fail")
    public void addItemToMyCartShouldFail() {
        addItemToCartExpectedToFail = true;
    }

    private IShoppingCart getCart() {
        return helper.getCart();
    }

}
