package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.domain.PriceList;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import cucumber.api.java.en.Given;


public class PriceListSteps {

    final private ShoppingHelper helper;

    public PriceListSteps(ShoppingHelper helper) {
        this.helper = helper;
    }

    @Given("the price of a {string} is {money}")
    public void thePriceOfAIs(String itemName, Money itemPrice) {
        getPriceList().putPrice(itemName,itemPrice);
    }

    private  PriceList getPriceList() {
        return helper.getPriceList();
    }

}
