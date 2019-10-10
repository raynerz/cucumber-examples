package ch.alika.cukes.shopping.domain;

import java.util.function.Function;

public interface IPricingFunction extends Function<String, Money> {
    Money apply(String productName);
}
