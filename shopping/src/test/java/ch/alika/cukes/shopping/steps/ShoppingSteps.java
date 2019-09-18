package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.domain.PriceList;
import ch.alika.cukes.shopping.domain.ShoppingCart;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ShoppingSteps {

    final private ShoppingHelper helper;

    public ShoppingSteps(ShoppingHelper helper) {
        this.helper = helper;
    }

    @Given("the price of a {string} is {money}")
    public void thePriceOfAIsCents(String itemName, Money itemPrice) {
        getPriceList().putPrice(itemName,itemPrice);
    }

    @When("I checkout with {int} {string}(s)")
    public void iCheckoutWithS(Integer quantity, String itemName) {
        getCart().add(itemName,quantity);
    }

    @Then("the total price should be {money}")
    public void theTotalPriceShouldBeCents(Money totalPrice) {
        assertThat(getCart().getTotalPrice(),is(totalPrice));
    }

    private  PriceList getPriceList() {
        return helper.getPriceList();
    }

    private ShoppingCart getCart() {
        return helper.getCart();
    }

}
