package ch.alika.cukes.shopping.domain;

class PriceUnknownException extends RuntimeException {
    PriceUnknownException(String productName) {
        super(String.format("Price is unknown for product [%s]",productName));
    }
}
