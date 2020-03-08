package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.support.ProductPrice;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;

import java.util.Map;

public class ParameterTypes {

    @ParameterType("\\$(\\d+\\.\\d+)")
    public Money money(String amount) {
        return Money.fromString(amount);
    }

    @DataTableType
    public ProductPrice authorEntry(Map<String, String> row) {
        final String productName = row.get("product");
        final Money price = Money.fromString(row.get("price"));
        return new ProductPrice(
                productName,
                price);
    }

}
