package ch.alika.cukes.shopping.domain;

import lombok.Value;

@Value
public class Money {
    private final int dollars;
    private final int cents;

    public static Money fromString(String amount) {
        amount = amount.replace("$","");
        String[] numbers = amount.split("\\.");
        final int dollars = Integer.parseInt(numbers[0]);
        final int cents = Integer.parseInt(numbers[1]);
        return new Money(dollars, cents);
    }

    public Money() {
        this(0,0);
    }

    Money(int dollars, int cents) {
        this.dollars = dollars + cents / 100;
        this.cents = cents % 100;
    }

    public Money multipliedBy(int quantity) {
        int totalCents = (getValueInCents()) * quantity;
        return new Money(0, totalCents);
    }

    Money plus(Money other) {
        int totalCents = getValueInCents() + other.getValueInCents();
        return new Money( 0, totalCents);
    }

    Money minus(Money other) {
        int totalCents = (getValueInCents())  - (other.getValueInCents());
        return new Money( 0, totalCents);
    }

    private int getValueInCents() {
        return this.dollars * 100 + this.cents;
    }
}
