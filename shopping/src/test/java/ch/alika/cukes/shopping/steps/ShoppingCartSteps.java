package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.IShoppingCart;
import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ShoppingCartSteps {

    final private ShoppingHelper helper;

    public ShoppingCartSteps(ShoppingHelper helper) {
        this.helper = helper;
    }

    @When("I add {int} {string}(s) to my cart")
    public void iAddItemToCart(Integer quantity, String itemName) {
        getCart().add(itemName,quantity);
    }

    @Then("the total price should be {money}")
    public void theTotalPriceShouldBe(Money totalPrice) {
        assertThat(getCart().getTotalPrice(),is(totalPrice));
    }

    private IShoppingCart getCart() {
        return helper.getCart();
    }

}
