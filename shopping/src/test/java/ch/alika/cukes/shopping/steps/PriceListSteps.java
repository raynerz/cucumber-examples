package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.IPriceList;
import ch.alika.cukes.shopping.support.ProductPrice;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import io.cucumber.java.en.Given;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ShoppingStepsSpringConfiguration.class)
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
