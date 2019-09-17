package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.domain.PriceList;
import ch.alika.cukes.shopping.domain.ShoppingCart;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ShoppingSteps {

    private static PriceList priceList = new PriceList();
    private ShoppingCart cart = new ShoppingCart(priceList);

    @Given("the price of a {string} is {money}")
    public void thePriceOfAIsCents(@SuppressWarnings("unused") String itemName, Money itemPrice) {
        priceList.putPrice(itemPrice);
    }

    @When("I checkout with {int} {string}(s)")
    public void iCheckoutWithS(Integer quantity, String itemName) {
        cart.add(itemName,quantity);
    }

    @Then("the total price should be {money}")
    public void theTotalPriceShouldBeCents(Money totalPrice) {
        assertThat(cart.getTotalPrice(),is(totalPrice));
    }

}
