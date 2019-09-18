package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.domain.Money;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Locale;

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
                this::getMoneyInstance
        ));
    }

    private Money getMoneyInstance(String amount) {
        return Money.fromString(amount);
    }
}
