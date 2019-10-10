package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.IPriceList;
import ch.alika.cukes.shopping.support.ProductPrice;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import cucumber.api.java.en.Given;

import java.util.List;


public class PriceListSteps {

    final private ShoppingHelper helper;

    public PriceListSteps(ShoppingHelper helper) {
        this.helper = helper;
    }

    @Given("the product prices are:")
    public void theProductPricesAre(List<ProductPrice> prices) {
       prices.forEach(i -> getPriceList().putPrice(i.getProductName(),i.getPrice()));
    }


    private IPriceList getPriceList() {
        return helper.getPriceList();
    }

}
