package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.Money;
import ch.alika.cukes.shopping.support.ProductPrice;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "money",           // name
                "\\$(\\d+\\.\\d+)", // regexp
                Money.class,       // type
                Money::fromString
        ));
        typeRegistry.defineDataTableType(new DataTableType(
                ProductPrice.class,
                (Map<String, String> row) -> new ProductPrice(row.get("product"),Money.fromString(row.get("price")))
        ));
    }

}
