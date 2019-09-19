package ch.alika.cukes.shopping.domain;

import java.util.function.Function;

public interface PricingFunction extends Function<String, Money> {
    Money apply(String productName);
}
