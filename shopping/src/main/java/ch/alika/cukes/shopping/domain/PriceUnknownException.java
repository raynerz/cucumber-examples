package ch.alika.cukes.shopping.domain;

public class PriceUnknownException extends RuntimeException {
    PriceUnknownException(String productName) {
        super(String.format("Price is unknown for product [%s]",productName));
    }
}
