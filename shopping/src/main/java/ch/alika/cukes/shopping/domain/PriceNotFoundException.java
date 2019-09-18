package ch.alika.cukes.shopping.domain;

class PriceNotFoundException extends RuntimeException {
    PriceNotFoundException(String productName) {
        super(String.format("Price not found for product [%s]",productName));
    }
}
