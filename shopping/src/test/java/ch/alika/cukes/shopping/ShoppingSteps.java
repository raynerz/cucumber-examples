package ch.alika.cukes.shopping;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ShoppingSteps {

    private static int bananaPrice = 0;
    private ShoppingCart cart = new ShoppingCart();


    @Given("the price of a {string} is {int} cents")
    public void thePriceOfAIsCents(@SuppressWarnings("unused") String itemName, Integer itemPrice) {
        bananaPrice = itemPrice;
    }

    @When("I checkout with {int} {string}(s)")
    public void iCheckoutWithS(Integer quantity, String itemName) {
        cart.add(itemName,quantity);
    }

    @Then("the total price should be {int} cents")
    public void theTotalPriceShouldBeCents(Integer totalPrice) {
        assertThat(cart.getTotalPrice(),is(totalPrice));
    }

    private static class ShoppingCart {
        private int totalQuantity = 0;

        Integer getTotalPrice() {
            return bananaPrice * totalQuantity;
        }

        void add(@SuppressWarnings("unused") String itemName, Integer quantity) {
            this.totalQuantity += quantity;
        }
    }

}
