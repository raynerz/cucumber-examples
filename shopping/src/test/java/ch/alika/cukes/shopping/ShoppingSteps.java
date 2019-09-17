package ch.alika.cukes.shopping;

import ch.alika.cukes.shopping.domain.Money;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ShoppingSteps {

    private static Money bananaPrice = new Money();
    private ShoppingCart cart = new ShoppingCart();


    @Given("the price of a {string} is {money}")
    public void thePriceOfAIsCents(@SuppressWarnings("unused") String itemName, Money itemPrice) {
        bananaPrice = itemPrice;
    }

    @When("I checkout with {int} {string}(s)")
    public void iCheckoutWithS(Integer quantity, String itemName) {
        cart.add(itemName,quantity);
    }

    @Then("the total price should be {money}")
    public void theTotalPriceShouldBeCents(Money totalPrice) {
        assertThat(cart.getTotalPrice(),is(totalPrice));
    }

    private static class ShoppingCart {
        private int totalQuantity = 0;

        Money getTotalPrice() {
            return bananaPrice.multipliedBy(totalQuantity);
        }

        void add(@SuppressWarnings("unused") String itemName, Integer quantity) {
            this.totalQuantity += quantity;
        }
    }

}
