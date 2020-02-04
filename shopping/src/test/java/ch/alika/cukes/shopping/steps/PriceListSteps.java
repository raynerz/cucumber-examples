package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.IPriceList;
import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.support.ProductPrice;
import ch.alika.cukes.shopping.support.ShoppingHelper;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class PriceListSteps {

    final private ShoppingHelper helper;


    public PriceListSteps(ShoppingHelper helper) {
        this.helper = helper;
    }

    @Given("the product prices are:")
    public void theProductPricesAre(List<ProductPrice> prices) {
       prices.forEach(i -> getPriceList().putPrice(i.getProductName(),i.getPrice()));
    }


    @DataTableType
    public ProductPrice authorEntry(Map<String, String> row) {
        final String productName = row.get("product");
        final Money price = Money.fromString(row.get("price"));
        return new ProductPrice(
                productName,
                price);
    }

    private IPriceList getPriceList() {
        return helper.getPriceList();
    }

}
