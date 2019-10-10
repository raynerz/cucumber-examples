package ch.alika.cukes.shopping.support;

import ch.alika.cukes.shopping.domain.Money;
import lombok.Value;

@Value
public class ProductPrice {
    private final String productName;
    private final Money price;
}
